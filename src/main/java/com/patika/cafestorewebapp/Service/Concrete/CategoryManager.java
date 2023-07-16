package com.patika.cafestorewebapp.Service.Concrete;

import com.patika.cafestorewebapp.Core.ErrorResult;
import com.patika.cafestorewebapp.Core.Result;
import com.patika.cafestorewebapp.Core.SuccessResult;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryUpdateDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.CategoryResponseDto;
import com.patika.cafestorewebapp.Entity.Category;
import com.patika.cafestorewebapp.Repository.CategoryRepository;
import com.patika.cafestorewebapp.Service.Contrats.CategoryService;
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
    public List<CategoryResponseDto> getAll() {
        List<Category> categories = this.categoryRepository.findAll();

        return categories
                .stream()
                .map(x -> this.modelMapper.map(x, CategoryResponseDto.class))
                .toList();
    }

    @Override
    public Result update(CategoryUpdateDto categoryUpdateDto) {
        this.categoryRepository.findById(categoryUpdateDto.getCategoryId()).orElseThrow(() -> new RuntimeException("ID'e ait kategori bulunamadı"));
        Category category = this.modelMapper.map(categoryUpdateDto, Category.class);
        this.categoryRepository.save(category);

        return new SuccessResult("The category has been successfully updated");
    }

    @Override
    public Result delete(int id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if (category.isEmpty()) {

            return new ErrorResult("The category was not found.");
        }
        this.categoryRepository.delete(category.get());

        return new SuccessResult("The category has been successfully deleted.");
    }
}
