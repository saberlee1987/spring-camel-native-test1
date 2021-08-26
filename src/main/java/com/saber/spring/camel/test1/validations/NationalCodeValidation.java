package com.saber.spring.camel.test1.validations;


import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = NationalCodeValidator.class)

public @interface NationalCodeValidation {

    String message() default "national Code is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
