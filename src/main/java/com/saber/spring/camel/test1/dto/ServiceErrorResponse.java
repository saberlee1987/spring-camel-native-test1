package com.saber.spring.camel.test1.dto;

import lombok.Data;

import java.util.List;
@Data
public class ServiceErrorResponse {
    private Integer code;
    private String message;
    private String originalMessage;
    private List<ServiceValidator> validations;
}
