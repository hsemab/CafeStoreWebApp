package com.patika.cafestorewebapp.Dtos.ResponseDto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Integer productId;

    private String productName;

    private String categoryName;

    private double price;

    private int unitInStock;

}
