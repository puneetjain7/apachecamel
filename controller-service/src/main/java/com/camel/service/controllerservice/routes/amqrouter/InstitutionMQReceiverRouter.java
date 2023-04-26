package com.camel.service.controllerservice.routes.amqrouter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class InstitutionMQReceiverRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		/*from("timer:active-mq-timer?period=10000")
		.transform().constant("MY MQ MESSAGE")
		.log("${body}")
		.to("activemq:my-controller-queue");
		*/
		
		from("activemq:institution-queue")
		.to("log:Received Institution Queue message");
		
		
		
	}

}
