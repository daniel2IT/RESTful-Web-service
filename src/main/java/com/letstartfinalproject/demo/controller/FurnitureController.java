package com.letstartfinalproject.demo.controller;

import com.letstartfinalproject.demo.cache.FurnitureCache;
import com.letstartfinalproject.demo.model.Furniture;
import com.letstartfinalproject.demo.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/")
@RestController
public class FurnitureController {

    @Autowired
    FurnitureRepository repository;

    @Autowired
    FurnitureCache furnitureCache;

    @GetMapping(value = "cache/furnitures/{name}")
    public Furniture getFurniture(@PathVariable final String name)
    {
        return furnitureCache.getFurniture(name);
    }


    @RequestMapping(value = "/allFurnitures", method = RequestMethod.GET)
    public Iterable<Furniture> getAllFurniture(){
        Iterable<Furniture> furnitureCollection = repository.findAll();
        return furnitureCollection;
    }

    @RequestMapping(value = "/furnitureById", method = RequestMethod.GET, params = { "id" })
    public Furniture getFurniture(@RequestParam(value = "id") Long id) {
        Furniture furniture = new Furniture();
        Optional<Furniture> furnitureOpt = repository.findById(id);
        if(furnitureOpt.isPresent()) {
            furniture = furnitureOpt.get();
        }
        return furniture;
    }

    @RequestMapping(value = "/furnitures", method = RequestMethod.POST)
    public Furniture addFurniture(@RequestParam(value="name") String name)
    {
        Furniture newFurniture = new Furniture(name);

        repository.save(newFurniture);

        return newFurniture;
    }

    @RequestMapping(value = "/furnitures", method = RequestMethod.DELETE)
    public Furniture deleteFurniture(@RequestParam(value = "id") Long id) {
        Furniture furnitureToDelete = new Furniture();
        Optional<Furniture> optionalFurniture = repository.findById(id);
        if(optionalFurniture.isPresent()) {
            furnitureToDelete = optionalFurniture.get();
            repository.deleteById(furnitureToDelete.getId());
        }
        return furnitureToDelete;
    }

    @RequestMapping(value = "/furnitures", method = RequestMethod.PUT)
    public Furniture editFurniture(@RequestParam(value = "id") Long id,
                             @RequestParam(value="name", required = false) String firstname) {
        Optional<Furniture> optionalFurniture = repository.findById(id);
        Furniture furniture = new Furniture(firstname);
        if(optionalFurniture.isPresent()) {
            furniture = optionalFurniture.get();
            if(firstname != null && furniture.getName() != firstname) {
                furniture.setName(firstname);
            }
            repository.save(furniture);
        }
        return furniture;
    }

}
