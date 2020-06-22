package com.letstartfinalproject.demo.controller;

import com.letstartfinalproject.demo.cache.CartCache;
import com.letstartfinalproject.demo.model.Cart;
import com.letstartfinalproject.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/")
@RestController
public class CartController {

    @Autowired
    CartRepository repository;

    @Autowired
    CartCache cartCache;

    @GetMapping(value = "cache/cart/{amount}")
    public Cart getCart(@PathVariable final String amount)
    {
        return cartCache.getCart(amount);
    }

    @RequestMapping(value = "/allCart", method = RequestMethod.GET)
    public Iterable<Cart> getAllCarts(){
        Iterable<Cart> cartCollection = repository.findAll();
        return cartCollection;
    }

    @RequestMapping(value = "/cartById", method = RequestMethod.GET, params = { "id" })
    public Cart getCart(@RequestParam(value = "id") int id) {
        Cart cart = new Cart();
        Optional<Cart> cartOpt = repository.findById(id);
        if(cartOpt.isPresent()) {
            cart = cartOpt.get();
        }
        return cart;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.POST)
    public Cart addCart(@RequestParam(value="amount") String amount,
                        @RequestParam(value="currency", required = false) String currency)
    {
        Cart newCart = new Cart(amount, currency);

        repository.save(newCart);

        return newCart;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.DELETE)
    public Cart deleteCart(@RequestParam(value = "id") int id) {
        Cart cartToDelete = new Cart();
        Optional<Cart> optionalCart = repository.findById(id);
        if(optionalCart.isPresent()) {
            cartToDelete = optionalCart.get();
            repository.deleteById( cartToDelete.getId());
        }
        return cartToDelete;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.PUT)
    public Cart editCart(@RequestParam(value = "id") int id,
                                   @RequestParam(value="amount", required = false) String amount,
                                    @RequestParam(value="currency", required = false) String currency) {
        Optional<Cart> optionalCart = repository.findById(id);
        Cart cart = new Cart(amount, currency);
        if(optionalCart.isPresent()) {
            cart = optionalCart.get();
            if(amount != null && cart.getAmount() != amount) {
                cart.setAmount(amount);
            }
            repository.save(cart);
        }
        return cart;
    }


}
