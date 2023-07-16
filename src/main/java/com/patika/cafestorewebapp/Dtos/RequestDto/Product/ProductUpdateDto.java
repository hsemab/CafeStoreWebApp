package com.patika.cafestorewebapp.Dtos.RequestDto.Product;

import com.patika.cafestorewebapp.Entity.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductUpdateDto {

    private Integer productId;

    private String productName;

    private Integer categoryId;

    private double price;

    private int unitInStock;
}
