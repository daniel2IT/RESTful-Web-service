package com.letstartfinalproject.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String address;

    public Client() {
    }


    public Client(String name,String address) {
        this.name = name;
        this.address = address;
    }

    //@JsonManagedReference
    @JsonBackReference
    @OneToMany(mappedBy = "client") // tas yra susietas butent su Furniture kur kuriam Clien client
    public List<Furniture> Furnitures = new ArrayList<>();
    //  @RestResource(path = "libraryAddress", rel="address")

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", Furnitures=" + Furnitures +
                '}';
    }
}
