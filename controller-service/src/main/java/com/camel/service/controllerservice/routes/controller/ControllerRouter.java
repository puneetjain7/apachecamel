package com.camel.service.controllerservice.routes.controller;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ControllerRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:first-timer")
		.transform().constant("This is transfored message")
		.to("log: first-timer-log");
	}

}
