package com.letstartfinalproject.demo.repository;

import com.letstartfinalproject.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="CART",path="cart")
public interface CartRepository extends JpaRepository<Cart,Integer> {
    public Cart findByAmount(String amount);

}
