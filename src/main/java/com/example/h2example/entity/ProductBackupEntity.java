package com.example.h2example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ProductBackupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(ProductEntity entity) {
        return Double.compare(entity.getPrice(), price) == 0 && Objects.equals(name, entity.getName());
    }
}