package com.camel.service.controllerservice.routes.amqrouter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.camel.service.controllerservice.lookup.Country;

@Component
public class FacilityMQReceiverRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		/*from("timer:active-mq-timer?period=10000")
		.transform().constant("MY MQ MESSAGE")
		.log("${body}")
		.to("activemq:my-controller-queue");
		*/
		restConfiguration().host("localhost").port(8080);
		from("activemq:facility-queue")
		.to("log:Received Facility Queue message")
		.setHeader("country", () -> "IND")

		.to("rest:get:/lookup/country/{country}")
		.log("${body}")

		.to("rest:get:/lookup/countrycode/{country}")
		.log("${body}")

		.to("rest:get:/lookup/countries")
		.unmarshal(new ListJacksonDataFormat(Country.class))
		.log("${body}");
		
	}

}
