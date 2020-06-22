package com.letstartfinalproject.demo.cache;

import com.letstartfinalproject.demo.model.Client;
import com.letstartfinalproject.demo.model.Furniture;
import com.letstartfinalproject.demo.repository.ClientRepository;
import com.letstartfinalproject.demo.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class FurnitureCache {


    @Autowired
    FurnitureRepository furnitureRepository;

    @Cacheable(value = "furnitureCache", key = "#name")
    public Furniture getFurniture(String name) {
        System.out.println("Retrieving from Database for name :" + name);
        return furnitureRepository.findByName(name);
    }

}
