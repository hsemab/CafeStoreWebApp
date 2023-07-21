package com.patika.cafestorewebapp.Core.Exception;

public class ProductNotFoundExceptionById extends RuntimeException{

    public ProductNotFoundExceptionById(int id) {
        super("Product not found by id. ID:"+id);
    }
}