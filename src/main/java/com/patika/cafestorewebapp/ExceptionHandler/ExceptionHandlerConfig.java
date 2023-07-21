package com.patika.cafestorewebapp.ExceptionHandler;

import com.patika.cafestorewebapp.Core.Exception.BusinessException;
import com.patika.cafestorewebapp.Core.Exception.CategoryNotFoundExceptionById;
import com.patika.cafestorewebapp.Core.Exception.ProductNotFoundExceptionById;
import com.patika.cafestorewebapp.Core.Results.ErrorDataResult;
import com.patika.cafestorewebapp.Core.Results.ErrorResult;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBusinessException(BusinessException businessException){
        return new ErrorResult(businessException.getMessage());
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(CategoryNotFoundExceptionById.class)
    public ResponseEntity<String> handleBookNotFoundExceptionById(CategoryNotFoundExceptionById e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(ProductNotFoundExceptionById.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult  handleBookNotFoundExceptionByTitle(ProductNotFoundExceptionById e){
        return new ErrorResult(e.getMessage());
    }
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e){
        return new ErrorResult(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Map<String, String>> handleValidation(MethodArgumentNotValidException e){
        Map<String, String> dict = new HashMap<>();
        if (!e.getFieldErrors().isEmpty()) {
            for (FieldError fieldError : e.getFieldErrors()){
                dict.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
        }
        return new ErrorDataResult<>(dict,"Validation Rules");
    }
/*    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleException(Exception e){
        return new ErrorResult(e.getMessage());
    }*/
}