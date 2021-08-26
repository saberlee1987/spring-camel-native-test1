package com.saber.spring.camel.test1.routes;

import com.saber.spring.camel.test1.dto.PersonDto;
import com.saber.spring.camel.test1.entities.PersonEntity;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.awt.*;

@Component
public class SavePersonRoute extends AbstractRestRouteBuilder {
    @Override
    public void configure() throws Exception {

        super.configure();

        rest("/person")
                .post("/save")
                .id("save-person-route")
                .description("Add new Person")
                .consumes(MediaType.APPLICATION_JSON)
                .produces(MediaType.APPLICATION_JSON)
                .responseMessage().code(200).responseModel(PersonEntity.class).endResponseMessage()
                .enableCORS(true)
                .bindingMode(RestBindingMode.json)
                .type(PersonDto.class)
                .route()
                .routeId("saver-person-route")
                .threads().threadName("save-person-route")
                .log("Request for Add new Person ====> ${in.body}")
                .to("bean-validator://save-person-validator")
                .to("bean:personServiceImpl?method=savePerson")
                .marshal().json(JsonLibrary.Jackson,PersonEntity.class)
                .log("Response add new Person ===> ${in.body}")
                .unmarshal().json(JsonLibrary.Jackson,PersonEntity.class)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
    }
}
