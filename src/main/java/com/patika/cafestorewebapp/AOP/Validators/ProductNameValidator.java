package com.patika.cafestorewebapp.AOP.Validators;

import com.patika.cafestorewebapp.AOP.Annotations.ProductNameMustBeUnique;
import com.patika.cafestorewebapp.Repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductNameValidator implements ConstraintValidator<ProductNameMustBeUnique, String> {
    private final ProductRepository productRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        int count = this.productRepository.countByProductName(s);
        return count <= 0;
    }
}
