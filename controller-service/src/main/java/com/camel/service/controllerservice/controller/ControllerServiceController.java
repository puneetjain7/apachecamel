package com.camel.service.controllerservice.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerServiceController {

	
	@Autowired
    private Queue queuePerson;

	@Autowired
    private Queue queueFacility;
	
	@Autowired
    private Queue queueInstitution;
	
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("message/{message}")
    public ResponseEntity<String> publish(@PathVariable("message")  String message){
    	
        if (message.equals("Facility"))
        	jmsTemplate.convertAndSend(queueFacility, message+" Message");
        
        else if (message.equals("Person"))
        	jmsTemplate.convertAndSend(queuePerson, message+" Message");
        
        else if (message.equals("Institution"))
        	jmsTemplate.convertAndSend(queueInstitution, message+" Message");
        
        return new ResponseEntity(message+": Success", HttpStatus.OK);
    }
	
	
	@GetMapping("/checkcontroller")
	public void findvalue()
	{
		System.out.println("A Simple service call");
	}
}
