package com.patika.cafestorewebapp.Dtos.RequestDto.Product;

import lombok.Data;

@Data
public class ProductUpdatePriceDto {
    private Integer productId;

    private double price;

}
