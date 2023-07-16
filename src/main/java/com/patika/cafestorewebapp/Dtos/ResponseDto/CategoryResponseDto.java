package com.patika.cafestorewebapp.Dtos.ResponseDto;

import com.patika.cafestorewebapp.Entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {
    private Integer categoryId;
    private String categoryName;
    private List<ProductListResponseDto> products;
}
