package com.saber.spring.camel.test1.routes;

import com.saber.spring.camel.test1.dto.ServiceErrorResponse;
import com.saber.spring.camel.test1.dto.ServiceValidator;
import com.saber.spring.camel.test1.exception.ResourceDuplicationException;
import com.saber.spring.camel.test1.exception.ResourceNotFoundException;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.camel.support.processor.PredicateValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AbstractRestRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        onException(BeanValidationException.class)
                .maximumRedeliveries(0)
                .handled(true)
                .process(exchange -> {
                    BeanValidationException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, BeanValidationException.class);
                    Set<ConstraintViolation<Object>> validators = exception.getConstraintViolations();
                    ServiceErrorResponse errorResponse = new ServiceErrorResponse();

                    errorResponse.setCode(400);
                    errorResponse.setMessage("Validation Error");
                    ServiceValidator serviceValidator = new ServiceValidator();
                    List<ServiceValidator> validatorList = new ArrayList<>();
                    validators.forEach(validator -> {
                        ServiceValidator serviceValidatorClone = serviceValidator.clone();
                        serviceValidatorClone.setFieldName(validator.getPropertyPath().toString());
                        serviceValidator.setErrorMessage(validator.getMessage());
                        validatorList.add(serviceValidatorClone);
                    });
                    errorResponse.setValidations(validatorList);
                    exchange.getMessage().setBody(errorResponse);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400));



        onException(ResourceNotFoundException.class)
                .maximumRedeliveries(0)
                .handled(true)
                .process(exchange -> {
                    ResourceNotFoundException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, ResourceNotFoundException.class);
                    ServiceErrorResponse errorResponse = new ServiceErrorResponse();

                    errorResponse.setCode(406);
                    errorResponse.setMessage("Resource Not found Exception");
                    errorResponse.setOriginalMessage(String.format("{\"code\":%d,\"message\":\"%s\"}", 406,exception.getMessage()));

                    exchange.getMessage().setBody(errorResponse);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(406));


        onException(DataIntegrityViolationException.class)
                .maximumRedeliveries(0)
                .handled(true)
                .process(exchange -> {
                    DataIntegrityViolationException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, DataIntegrityViolationException.class);
                    ServiceErrorResponse errorResponse = new ServiceErrorResponse();

                    errorResponse.setCode(406);
                    errorResponse.setMessage(exception.getMessage());
                    errorResponse.setOriginalMessage(String.format("{\"code\":%d,\"message\":\"%s\"}", 406,exception.getMessage()));

                    exchange.getMessage().setBody(errorResponse);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(406));


        onException(ResourceDuplicationException.class)
                .maximumRedeliveries(0)
                .handled(true)
                .process(exchange -> {
                    ResourceDuplicationException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, ResourceDuplicationException.class);
                    ServiceErrorResponse errorResponse = new ServiceErrorResponse();

                    errorResponse.setCode(406);
                    errorResponse.setMessage(exception.getMessage());
                    errorResponse.setOriginalMessage(String.format("{\"code\":%d,\"message\":\"%s\"}", 406,exception.getMessage()));

                    exchange.getMessage().setBody(errorResponse);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(406));

        onException(PredicateValidationException.class)
                .maximumRedeliveries(0)
                .handled(true)
                .process(exchange -> {
                    PredicateValidationException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, PredicateValidationException.class);

                    Predicate predicate = exception.getPredicate();

                    ServiceErrorResponse errorResponse = new ServiceErrorResponse();

                    errorResponse.setCode(400);
                    errorResponse.setMessage("Validation Error");
                    errorResponse.setOriginalMessage(String.format("{\"code\":%d,\"message\":\"%s\"}", 400,predicate.toString()));

                    exchange.getMessage().setBody(errorResponse);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400));



    }
}
