package com.patika.cafestorewebapp.Controller;

import com.patika.cafestorewebapp.Core.Results.DataResult;
import com.patika.cafestorewebapp.Core.Results.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Category.CategoryUpdateDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.CategoryResponseDto;
import com.patika.cafestorewebapp.Service.Contrats.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cafe/categories")
@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CategoryAddDto categoryAddDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.add(categoryAddDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<CategoryResponseDto>>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.getAll());
    }
    @GetMapping("/getById")
    public ResponseEntity<DataResult<CategoryResponseDto>> getById(@RequestParam int id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.getById(id));
    }
    @PostMapping("/update")
    public ResponseEntity<Result> updateCategory(@Valid @RequestBody CategoryUpdateDto categoryUpdateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.categoryService.update(categoryUpdateDto));
    }
    @PostMapping("/delete")
    public ResponseEntity<Result> deleteCategoryById(@RequestParam int id){
        var data = this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);

    }
}
