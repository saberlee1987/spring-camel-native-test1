package com.saber.spring.camel.test1.dto;

import lombok.Data;

@Data
public class ServiceValidator implements Cloneable {
    private String fieldName;
    private String errorMessage;

    @Override
    public ServiceValidator clone()  {
       try {
           return (ServiceValidator) super.clone();
       }catch (Exception ex){
           return null;
       }
    }
}
