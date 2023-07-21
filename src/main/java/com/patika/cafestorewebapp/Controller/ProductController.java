package com.patika.cafestorewebapp.Controller;

import com.patika.cafestorewebapp.Core.Results.DataResult;
import com.patika.cafestorewebapp.Core.Results.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdateDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdatePriceDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.ProductResponseDto;
import com.patika.cafestorewebapp.Service.Contrats.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cafe/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Create
    @PostMapping("/add")
    public ResponseEntity<Result> addProduct(@Valid @RequestBody ProductAddDto productAddDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.add(productAddDto));
    }

    // Read
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<ProductResponseDto>>> getAllProducts() {

        return ResponseEntity.status(HttpStatus.OK).body(this.productService.getAll());
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<ProductResponseDto>> getById(@RequestParam int id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.productService.getById(id));
    }

    // Update
    @PostMapping("/update")
    public ResponseEntity<Result> updateProduct(@Valid @RequestBody ProductUpdateDto productUpdateDto) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.productService.update(productUpdateDto));
    }

    @PostMapping("/updatePrice")
    public ResponseEntity<Result> updateProductPrice(@Valid @RequestBody ProductUpdatePriceDto productUpdatePriceDto) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.productService.updatePrice(productUpdatePriceDto));
    }

    //Delete
    @PostMapping("/delete")
    public ResponseEntity<Result> deleteProductById(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.delete(id));

    }

}
