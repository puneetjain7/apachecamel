package com.camel.service.controllerservice.lookup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lookupservice")
public class LookupServiceImpl implements LookupService {

	@Autowired
	CountryDAO countrydao;
	
	
	public List getCountries() {
		 
		return countrydao.getCountries();
		}
		 
		@Override
		public Country getCountry(String countryCode) {
		return countrydao.getCountry(countryCode);
		 
		}
		
}
