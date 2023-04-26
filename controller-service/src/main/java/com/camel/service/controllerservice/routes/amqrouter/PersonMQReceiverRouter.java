package com.camel.service.controllerservice.routes.amqrouter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PersonMQReceiverRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		/*from("timer:active-mq-timer?period=10000")
		.transform().constant("MY MQ MESSAGE")
		.log("${body}")
		.to("activemq:my-controller-queue");
		*/
		
		from("activemq:person-queue")
		.to("log:Received Person Queue message")
		.log("${body}");
		
		
		
	}

}
