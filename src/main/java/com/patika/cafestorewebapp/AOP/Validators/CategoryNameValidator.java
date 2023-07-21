package com.patika.cafestorewebapp.AOP.Validators;

import com.patika.cafestorewebapp.AOP.Annotations.CategoryNameMustBeUnique;
import com.patika.cafestorewebapp.Repository.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryNameValidator implements ConstraintValidator<CategoryNameMustBeUnique, String> {
    private final CategoryRepository categoryRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        int count = this.categoryRepository.countByCategoryName(s);
        return count <= 0;
    }
}
