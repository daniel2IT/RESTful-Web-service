package com.letstartfinalproject.demo.repository;

import com.letstartfinalproject.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="CLIENT",path="client") //Furniture
public interface ClientRepository extends JpaRepository<Client,Long>  {
    Client findByName(String name);
}