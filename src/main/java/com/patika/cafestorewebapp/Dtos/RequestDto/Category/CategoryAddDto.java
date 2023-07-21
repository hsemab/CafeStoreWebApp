package com.patika.cafestorewebapp.Dtos.RequestDto.Category;

import com.patika.cafestorewebapp.AOP.Annotations.CategoryNameMustBeUnique;
import lombok.Data;

@Data
public class CategoryAddDto {
    @CategoryNameMustBeUnique
    private String categoryName;
}
