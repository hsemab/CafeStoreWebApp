package com.patika.cafestorewebapp.Service.Concrete;

import com.patika.cafestorewebapp.Core.Exception.CategoryNotFoundExceptionById;
import com.patika.cafestorewebapp.Core.Results.*;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryUpdateDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.CategoryResponseDto;
import com.patika.cafestorewebapp.Entity.Category;
import com.patika.cafestorewebapp.Repository.CategoryRepository;
import com.patika.cafestorewebapp.Service.Contrats.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Result add(CategoryAddDto categoryAddDto) {
        Category category = this.modelMapper.map(categoryAddDto, Category.class);
        category.setCategoryId(null);
        this.categoryRepository.save(category);
        return new SuccessResult("The product has been successfully added");
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryResponseDto> responseDtoList = categories.stream().map(x -> this.modelMapper.map(x, CategoryResponseDto.class)).toList();
        return new SuccessDataResult<>(responseDtoList);
    }

    @Override
    public DataResult<CategoryResponseDto> getById(int id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new CategoryNotFoundExceptionById(id);
        }
        CategoryResponseDto responseDto = this.modelMapper.map(category.get(),CategoryResponseDto.class);
        return new SuccessDataResult<>(responseDto);
    }
    @Override
    public Result update(CategoryUpdateDto categoryUpdateDto) {
        this.categoryRepository.findById(categoryUpdateDto.getCategoryId()).orElseThrow(() -> new CategoryNotFoundExceptionById(categoryUpdateDto.getCategoryId()));
        Category category = this.modelMapper.map(categoryUpdateDto, Category.class);
        this.categoryRepository.save(category);
        return new SuccessResult("The category has been successfully updated");
    }

    @Override
    public Result delete(int id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundExceptionById(id));
        this.categoryRepository.delete(category);
        return new SuccessResult("The category has been successfully deleted.");
    }


}
