package com.patika.cafestorewebapp.Dtos.RequestDto.Product;

import lombok.Data;

@Data
public class ProductAddDto {

    private String productName;

    private Integer categoryId;

    private double price;

    private int unitInStock;
}
