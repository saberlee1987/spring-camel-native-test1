package com.saber.spring.camel.test1.dto;

import com.saber.spring.camel.test1.validations.NationalCodeValidation;
import lombok.Data;
import org.checkerframework.checker.units.qual.min;

import javax.validation.constraints.*;

@Data
public class PersonDto {
    @NotBlank(message = "firstName is Required")
    private String firstName;
    @NotBlank(message = "lastName is Required")
    private String lastName;
    @NotBlank(message = "nationalCode is Required")
    @Size(min = 10, max = 10, message = "nationalCode must be 10 digit")
    @Pattern(regexp = "\\d+",message = "please enter correct nationalCode")
    @NationalCodeValidation(message = "national Code not valid")
    private String nationalCode;
    @NotNull(message = "age is Required")
    @Positive(message = "age must be > 0")
    @Max(value = 999,message = "age must be < 999")
    private Integer age;
    @NotBlank(message = "mobile is Required")
    private String mobile;

}
