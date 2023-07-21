package com.patika.cafestorewebapp.Service.Contrats;

import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryUpdateDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.CategoryResponseDto;

public interface CategoryService extends BaseService<CategoryAddDto, CategoryUpdateDto,CategoryResponseDto> {

}
