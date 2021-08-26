package com.saber.spring.camel.test1.routes;

import com.saber.spring.camel.test1.dto.wsdl.basicinformation.ArrayOfBasicInformation;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Component;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetCountries extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        rest("/basicInformation")
                .get("/getCountries")
                .id("get-countries")
                .description("Get Countries")
                .produces(MediaType.APPLICATION_JSON)
                .enableCORS(true)
                .bindingMode(RestBindingMode.off)
                .responseMessage().code(200).responseModel(ArrayOfBasicInformation.class).endResponseMessage()
                .route()
                .routeId("get-countries")
                .process(exchange -> {
                    List<Object> params = new ArrayList<>();
                    exchange.getIn().setBody(params);
                })
                .setHeader(CxfConstants.OPERATION_NAME, constant("GetCountries"))
                .to("cxf:bean:Basicinformationqueryservice")
                .log("GetCountries web Services Called ")
                .process(exchange -> {
                    ArrayOfBasicInformation basicInformation = (ArrayOfBasicInformation) exchange.getMessage().getBody(MessageContentsList.class).get(0);
                    exchange.getMessage().setBody(basicInformation);
                })
                .marshal().json(JsonLibrary.Jackson)
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
    }
}
