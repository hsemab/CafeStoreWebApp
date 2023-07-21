package com.patika.cafestorewebapp.Service.Concrete;

import com.patika.cafestorewebapp.Core.Exception.ProductNotFoundExceptionById;
import com.patika.cafestorewebapp.Core.Results.*;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdateDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdatePriceDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.ProductResponseDto;
import com.patika.cafestorewebapp.Entity.Product;
import com.patika.cafestorewebapp.Repository.ProductRepository;
import com.patika.cafestorewebapp.Service.Contrats.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Result add(ProductAddDto productAddDto) {
        Product product = this.modelMapper.map(productAddDto, Product.class);
        product.setProductId(null);
        this.productRepository.save(product);
        return new SuccessResult("The product has been successfully added");
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAll() {
        List<Product> products = this.productRepository.findAll();
        List<ProductResponseDto> responseDtoList = products.stream().map(x -> this.modelMapper.map(x, ProductResponseDto.class)).toList();
        return new SuccessDataResult<>(responseDtoList);
    }

    @Override
    public DataResult<ProductResponseDto> getById(int id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundExceptionById(id);
        }
        ProductResponseDto responseDto = this.modelMapper.map(product.get(), ProductResponseDto.class);
        return new SuccessDataResult<>(responseDto);
    }

    @Override
    public Result update(ProductUpdateDto productUpdateDto) {
        this.productRepository.findById(productUpdateDto.getProductId()).orElseThrow(() -> new ProductNotFoundExceptionById(productUpdateDto.getProductId()));
        Product product = this.modelMapper.map(productUpdateDto, Product.class);
        this.productRepository.save(product);
        return new SuccessResult("The product has been successfully updated");

    }

    @Override
    public Result updatePrice(ProductUpdatePriceDto productUpdatePriceDto) {
        Product product = this.productRepository.findById(productUpdatePriceDto.getProductId()).orElseThrow(() -> new ProductNotFoundExceptionById(productUpdatePriceDto.getProductId()));
        product.setPrice(productUpdatePriceDto.getPrice());
        this.productRepository.save(product);
        return new SuccessResult("The product has been successfully updated");

    }

    @Override
    public Result delete(int id) {
        Product product = this.productRepository.findById(id).orElseThrow(()-> new ProductNotFoundExceptionById(id));
        this.productRepository.delete(product);
        return new SuccessResult("The product has been successfully deleted.");

    }

}
