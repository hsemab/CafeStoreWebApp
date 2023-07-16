package com.patika.cafestorewebapp.Controller;

import com.patika.cafestorewebapp.Core.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdateDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdatePriceDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.ProductResponseDto;
import com.patika.cafestorewebapp.Service.Contrats.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cafe/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Create
    @PostMapping("/add")
    public Result addProduct(@RequestBody ProductAddDto productAddDto) {

        return this.productService.add(productAddDto);
    }

    // Read
    @GetMapping("/getAll")
    public List<ProductResponseDto> getAllProducts() {

        return this.productService.getAll();
    }

    @GetMapping("/getById")
    public ProductResponseDto getById(@RequestParam int id) {

        return this.productService.getById(id);
    }

    // Update
    @PostMapping("/update")
    public Result updateProduct(@RequestBody ProductUpdateDto productUpdateDto) {

        return this.productService.update(productUpdateDto);
    }

    @PostMapping("/updatePrice")
    public Result updateProductPrice(@RequestBody ProductUpdatePriceDto productUpdatePriceDto) {

        return this.productService.updatePrice(productUpdatePriceDto);
    }

    //Delete
    @PostMapping("/deleteById")
    public Result deleteProductById(@RequestParam int id) {
        return this.productService.delete(id);

    }

}
