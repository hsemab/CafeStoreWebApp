package com.patika.cafestorewebapp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private double price;

    @Column
    private int unitInStock;
}