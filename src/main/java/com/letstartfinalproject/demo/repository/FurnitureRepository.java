package com.letstartfinalproject.demo.repository;

import com.letstartfinalproject.demo.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="FURNITURE",path="furniture") // CrudRepository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    Furniture findByName(String name);
}
