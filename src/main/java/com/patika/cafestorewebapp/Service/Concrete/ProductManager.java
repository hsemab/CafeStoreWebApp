package com.patika.cafestorewebapp.Service.Concrete;

import com.patika.cafestorewebapp.Core.ErrorResult;
import com.patika.cafestorewebapp.Core.Result;
import com.patika.cafestorewebapp.Core.SuccessResult;
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
    public List<ProductResponseDto> getAll() {
        List<Product> products = this.productRepository.findAll();
        return products
                .stream()
                .map(x -> this.modelMapper.map(x, ProductResponseDto.class))
                .toList();
    }

    @Override
    public ProductResponseDto getById(int id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isEmpty()) {
            return null;
        }
        return this.modelMapper.map(product.get(), ProductResponseDto.class);
    }

    @Override
    public Result update(ProductUpdateDto productUpdateDto) {
        this.productRepository.findById(productUpdateDto.getProductId()).orElseThrow(() -> new RuntimeException("ID'e ait product bulunamadı"));
        Product product = this.modelMapper.map(productUpdateDto, Product.class);
        this.productRepository.save(product);
        return new SuccessResult("The product has been successfully updated");

    }

    @Override
    public Result updatePrice(ProductUpdatePriceDto productUpdatePriceDto) {
        Product product = this.productRepository.findById(productUpdatePriceDto.getProductId()).orElseThrow(() -> new RuntimeException("ID'e ait product bulunamadı"));
        product.setPrice(productUpdatePriceDto.getPrice());
        this.productRepository.save(product);
        return new SuccessResult("The product has been successfully updated");

    }


    @Override
    public Result delete(int id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isEmpty()) {
            return new ErrorResult("The product was not found.");
        }
        this.productRepository.delete(product.get());
        return new SuccessResult("The product has been successfully deleted.");

    }

}
