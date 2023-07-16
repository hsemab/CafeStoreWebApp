package com.patika.cafestorewebapp.Dtos.ResponseDto;

import lombok.Data;

@Data
public class ProductListResponseDto {
    private Integer productId;

    private String productName;

    private double price;
}
