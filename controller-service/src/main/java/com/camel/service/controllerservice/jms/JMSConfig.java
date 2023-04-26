package com.camel.service.controllerservice.jms;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
public class JMSConfig {
	
	@Bean
    public Queue queuePerson(){
        return new ActiveMQQueue("person-queue");
    }
	
	@Bean
    public Queue queueFacility(){
        return new ActiveMQQueue("facility-queue");
    }

	@Bean
    public Queue queueInstitution(){
        return new ActiveMQQueue("institution-queue");
    }
	
}
