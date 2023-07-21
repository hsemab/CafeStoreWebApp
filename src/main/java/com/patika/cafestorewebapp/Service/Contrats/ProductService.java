package com.patika.cafestorewebapp.Service.Contrats;

import com.patika.cafestorewebapp.Core.Results.Result;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductAddDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdateDto;
import com.patika.cafestorewebapp.Dtos.RequestDto.Product.ProductUpdatePriceDto;
import com.patika.cafestorewebapp.Dtos.ResponseDto.ProductResponseDto;

public interface ProductService extends BaseService<ProductAddDto, ProductUpdateDto, ProductResponseDto> {

    Result updatePrice(ProductUpdatePriceDto productUpdatePriceDto);


}
