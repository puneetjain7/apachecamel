package com.camel.service.controllerservice.lookup;

import java.util.List;

public interface CountryDAO {
	Country getCountry(String countryCode);
	List getCountries();
}
