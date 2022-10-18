package com.kama.scraper.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "title_sequence",
            sequenceName = "title_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "title_sequence"
    )
    private Long id;


    private String name;
    private String price;

    public Product() {}

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Product(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }



    @ManyToMany
    @JoinTable(
            name = "user_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> userProducts = new HashSet<>();
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public Set<User> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(Set<User> userProducts) {
        this.userProducts = userProducts;
    }

    public void saveToUser(User user) {
        userProducts.add(user);
    }
}


