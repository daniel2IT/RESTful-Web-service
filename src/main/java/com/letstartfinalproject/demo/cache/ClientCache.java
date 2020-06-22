package com.letstartfinalproject.demo.cache;

import com.letstartfinalproject.demo.model.Client;
import com.letstartfinalproject.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ClientCache {


    @Autowired
    ClientRepository clientRepository;


    @Cacheable(value = "clientsCache", key = "#name")
    public Client getClient(String name) {
        System.out.println("Retrieving from Database for name :" + name);
        return clientRepository.findByName(name);
    }
}
