package com.patika.cafestorewebapp.Controller;

import com.patika.cafestorewebapp.Core.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryUpdateDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.CategoryResponseDto;
import com.patika.cafestorewebapp.Service.Contrats.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cafe/categories")
@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public Result add(@RequestBody CategoryAddDto categoryAddDto) {

        return this.categoryService.add(categoryAddDto);
    }

    @GetMapping("/getAll")
    public List<CategoryResponseDto> getAll() {

        return this.categoryService.getAll();
    }
    @PostMapping("/update")
    public Result updateCategory(@RequestBody CategoryUpdateDto categoryUpdateDto){
        return this.categoryService.update(categoryUpdateDto);
    }
    @PostMapping("/delete")
    public Result deleteCategoryById(@RequestParam int id){
        return this.categoryService.delete(id);
    }
}
