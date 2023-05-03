package com.kodlamaio.commonpackage.utils.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Annotation;
import java.time.Year;


public class NotFutureYearValidator implements ConstraintValidator<NotFutureYear, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        int currentYear = Year.now().getValue();
        return value <= currentYear;
    }


}
