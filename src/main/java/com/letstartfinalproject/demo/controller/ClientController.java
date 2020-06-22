package com.letstartfinalproject.demo.controller;


import com.letstartfinalproject.demo.cache.ClientCache;
import com.letstartfinalproject.demo.model.Client;
import com.letstartfinalproject.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/")
@RestController
public class ClientController {

   @Autowired
   ClientRepository repository;

   @Autowired
   private ClientCache clientsCache;

    @GetMapping(value = "cache/clients/{name}")
    public Client getClient(@PathVariable final String name)
    {
        return clientsCache.getClient(name);
    }

    @RequestMapping(value = "/allClients", method = RequestMethod.GET)
    public Iterable<Client> getAllClients(){
        Iterable<Client> clientsCollection = repository.findAll();
        return clientsCollection;
    }

    @RequestMapping(value = "/clientById", method = RequestMethod.GET, params = { "id" })
    public Client getClient(@RequestParam(value = "id") Long id) {
        Client client = new Client();
        Optional<Client> clientOpt = repository.findById(id);
        if(clientOpt.isPresent()) {
            client = clientOpt.get();
        }
        return client;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public Client addClient(@RequestParam(value="name") String name,
                              @RequestParam(value="adress") String adress) {
        Client newClient = new Client(name, adress);

        repository.save(newClient);

        return newClient;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.DELETE)
    public Client deleteClient(@RequestParam(value = "id") Long id) {
        Client clientToDelete = new Client();
        Optional<Client> optionalClient = repository.findById(id);
        if(optionalClient.isPresent()) {
            clientToDelete = optionalClient.get();
            repository.deleteById(clientToDelete.getId());
        }
        return clientToDelete;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.PUT)
    public Client editClient(@RequestParam(value = "id") Long id,
                               @RequestParam(value="name", required = false) String firstname,
                               @RequestParam(value="adress", required = false) String lastname) {
        Optional<Client> optionalClient = repository.findById(id);
        Client client = new Client();
        if(optionalClient.isPresent()) {
            client = optionalClient.get();
            if(firstname != null && client.getName() != firstname) {
                client.setName(firstname);
            }
            if(lastname != null && client.getAddress() != lastname) {
                client.setAddress(lastname);
            }
            repository.save(client);
        }
        return client;
    }


}
