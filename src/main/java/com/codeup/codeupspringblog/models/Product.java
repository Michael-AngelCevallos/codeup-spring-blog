package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import org.springframework.web.bind.annotation.GetMapping;




@Entity
@Table(name = "products") // use jakarata annotations
public class Product {



@Id //  this tells jpa that this is your primary key
@GeneratedValue(strategy  = GenerationType.IDENTITY) // this is auto increment
 private long id; // THIS SERVES AS YOUR PRIMARY



@Column(nullable = false)
 private String name;
 private int costInCents;

    public Product() {
    }

    public Product(String name, int costInCents) {
           this.name = name;
        this.costInCents = costInCents;
}

    public Product(long id, String name, int costInCents) {
        this.id = id;
        this.name = name;
        this.costInCents = costInCents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(int costInCents) {
        this.costInCents = costInCents;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costInCents=" + costInCents +
                '}';
    }
}
