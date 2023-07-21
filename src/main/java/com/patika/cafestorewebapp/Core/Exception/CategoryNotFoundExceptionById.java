package com.patika.cafestorewebapp.Core.Exception;

public class CategoryNotFoundExceptionById extends RuntimeException{

    public CategoryNotFoundExceptionById(int id) {
           super("Category not found by id. ID:"+id);
    }
}
