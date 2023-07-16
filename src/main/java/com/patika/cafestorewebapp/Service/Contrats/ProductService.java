package com.patika.cafestorewebapp.Service.Contrats;

import com.patika.cafestorewebapp.Core.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdateDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdatePriceDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    //Create
    Result add(ProductAddDto productAddDto);

    //Read
    List<ProductResponseDto> getAll();

    ProductResponseDto getById(int id);

    //Update
    Result update(ProductUpdateDto productUpdateDto);

    Result updatePrice(ProductUpdatePriceDto productUpdatePriceDto);

    //Delete
    Result delete(int id);


}
