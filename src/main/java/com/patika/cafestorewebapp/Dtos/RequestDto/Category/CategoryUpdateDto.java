package com.patika.cafestorewebapp.Dtos.RequestDto.Category;

import com.patika.cafestorewebapp.AOP.Annotations.CategoryNameMustBeUnique;
import lombok.Data;

@Data
public class CategoryUpdateDto {
    private Integer categoryId;
    @CategoryNameMustBeUnique
    private String categoryName;
}
