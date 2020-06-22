package com.letstartfinalproject.demo.cache;

import com.letstartfinalproject.demo.model.Cart;
import com.letstartfinalproject.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CartCache {

    @Autowired
    CartRepository cartRepository;

    @Cacheable(value = "cartCache", key = "#amount")
    public Cart getCart(String amount) {
        System.out.println("Retrieving from Database for name :" + amount);
        return cartRepository.findByAmount(amount);
    }
}
