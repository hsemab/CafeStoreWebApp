package com.patika.cafestorewebapp.Dtos.RequestDto.Product;

import com.patika.cafestorewebapp.AOP.Annotations.ProductNameMustBeUnique;
import lombok.Data;

@Data
public class ProductAddDto {

    @ProductNameMustBeUnique
    private String productName;

    private Integer categoryId;

    private double price;

    private int unitInStock;
}
