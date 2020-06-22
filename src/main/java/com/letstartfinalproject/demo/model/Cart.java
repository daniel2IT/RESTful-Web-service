package com.letstartfinalproject.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String amount;
    public String currency;

    public List<Furniture> getFurnitures() {
        return Furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        Furnitures = furnitures;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @JsonBackReference
   // @JsonManagedReference
    @OneToMany(mappedBy = "cart") // tas yra susietas butent su Furniture kur kuriam Clien client
    public List<Furniture> Furnitures = new ArrayList<>();

    public Cart(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public Cart(int id,String amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public Cart() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
