package com.saber.spring.camel.test1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RouteDefinition extends RouteBuilder {
    @Value(value = "${service.api.basePath}")
    private String apiBasePath;
    @Override
    public void configure() throws Exception {

        restConfiguration()
                .contextPath(apiBasePath)
                .apiContextPath("/v2/api-docs")
                .apiProperty("api.title","Camel Spring native test")
                .apiProperty("api.version","version 1.1")
                .apiProperty("cors","true")
                .enableCORS(true)
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint","true");
    }
}
