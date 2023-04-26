package com.camel.service.controllerservice.controller;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camel.service.controllerservice.lookup.Country;
import com.camel.service.controllerservice.lookup.LookupService;

@RestController
@RequestMapping("/lookup")
public class LookupServiceController {

	@Autowired
	LookupService lookupservice;
	

	@GetMapping(value="/countries", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getCountries()
	{
	List countries=lookupservice.getCountries();
	HttpStatus ResponseHTTPStatus= (countries.size() >= 0) ? HttpStatus.OK: HttpStatus.NO_CONTENT;
	return new ResponseEntity(countries, ResponseHTTPStatus);
	}	
	
	@GetMapping(value="/countrycode/{countrycode}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getCountry(@PathVariable("countrycode") String countryCode)
	{
	Country b=lookupservice.getCountry(countryCode);
	HttpStatus ResponseHTTPStatus= (b.getCountryDescription().length() >= 0) ? HttpStatus.OK: HttpStatus.NO_CONTENT;
	return new ResponseEntity (b.getCountryDescription(), ResponseHTTPStatus);
	}
	
	
    @GetMapping("country/{country}")
    public ResponseEntity<String> publish(@PathVariable("country")  String country){
    	
        if (country.equals("IND"))
        	country= "India";
        
        if (country.equals("US"))
        	country= "USA";
        
        return new ResponseEntity(country, HttpStatus.OK);
    }
	
	
	@GetMapping("/checkcontroller")
	public void findvalue()
	{
		System.out.println("A Simple service call");
	}
}
