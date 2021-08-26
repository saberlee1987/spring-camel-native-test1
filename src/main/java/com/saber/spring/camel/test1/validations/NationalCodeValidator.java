package com.saber.spring.camel.test1.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NationalCodeValidator implements ConstraintValidator<NationalCodeValidation, String> {
    @Override
    public boolean isValid(String nationalCode, ConstraintValidatorContext constraintValidatorContext) {

        int[] digitalNumber = new int[nationalCode.length()];
        for (int i=0;i<nationalCode.length();i++){
            digitalNumber[i] = Integer.parseInt(String.valueOf(nationalCode.charAt(i)));
        }
        int controlNumber = digitalNumber[9];
        int sum = 0;
        int k = 10;
        for (int i = 0; i < 9; i++) {
            sum+= digitalNumber[i] * k;
            k--;
        }
        int reminder = sum %11;
        if (reminder <2){
            return controlNumber == reminder;
        }
        return  controlNumber == ( 11 - reminder);
    }
}
