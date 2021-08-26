package com.saber.spring.camel.test1.routes;

import com.saber.spring.camel.test1.dto.ServiceErrorResponse;
import com.saber.spring.camel.test1.entities.PersonEntity;
import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class FindPersonByNationalCodeRoute extends AbstractRestRouteBuilder {

    @Override
    public void configure() throws Exception {
        super.configure();

        rest("/person")
                .get("/findByNationalCode")
                .id("find-person-by-nationalCode-route")
                .description("find Person By NationalCode")
                .produces(MediaType.APPLICATION_JSON)
                .responseMessage().code(200).responseModel(PersonEntity.class).endResponseMessage()
                .responseMessage().code(400).responseModel(ServiceErrorResponse.class).endResponseMessage()
                .responseMessage().code(406).responseModel(ServiceErrorResponse.class).endResponseMessage()
                .responseMessage().code(500).responseModel(ServiceErrorResponse.class).endResponseMessage()
                .responseMessage().code(504).responseModel(ServiceErrorResponse.class).endResponseMessage()
                .param().name("nationalCode").type(RestParamType.query).required(true).example("0079028748").endParam()
                .enableCORS(true)
                .bindingMode(RestBindingMode.json)
                .route()
                .routeId("find-person-by-nationalCode-route")
                .threads().threadName("find-person-by-nationalCode-route")
                .validate(header("nationalCode").isNotNull())
                .validate(header("nationalCode").regex("\\d+"))
                .log("Request for find Person by nationalCode ===> ${in.header.nationalCode}")
                .to("bean:personServiceImpl?method=findByNationalCode")
                .marshal().json(JsonLibrary.Jackson,PersonEntity.class)
                .log("Response find Person by NationalCode ==> ${in.header.nationalCode} ===> ${in.body}")
                .unmarshal().json(JsonLibrary.Jackson,PersonEntity.class)
                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(200));

    }
}
