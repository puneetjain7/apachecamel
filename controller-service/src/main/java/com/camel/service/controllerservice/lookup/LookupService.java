package com.camel.service.controllerservice.lookup;

import java.util.List;

public interface LookupService {

	Country getCountry(String countryCode);
	List getCountries();
	
}
