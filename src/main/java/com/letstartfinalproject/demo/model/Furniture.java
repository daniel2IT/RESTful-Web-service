package com.letstartfinalproject.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.letstartfinalproject.demo.enums.Color;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Table(name="FURNITURE")
public class Furniture
{
    @Id // Primary key
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long id;
    public String name;


    @Enumerated(EnumType.STRING)
    public Color color;


    public Furniture(){
    }
    public Furniture(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonBackReference
    @ManyToOne
    @RestResource(path = "CLIENT", rel = "client")
    @JoinColumn(name="CLIENT_ID", nullable=false)
    public Client client;


    @JsonBackReference
    @ManyToOne
    @RestResource(path = "CART", rel = "cart")
    @JoinColumn(name="CART_ID", nullable=false)
    public Cart cart;

}
