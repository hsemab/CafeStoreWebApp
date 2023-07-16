package com.patika.cafestorewebapp.Service.Contrats;

import com.patika.cafestorewebapp.Core.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryUpdateDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    Result add(CategoryAddDto categoryAddDto);

    List<CategoryResponseDto> getAll();

    Result update(CategoryUpdateDto categoryUpdateDto);

    Result delete(int id);
}
