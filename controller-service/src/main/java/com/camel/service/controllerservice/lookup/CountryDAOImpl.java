package com.camel.service.controllerservice.lookup;

import java.util.List;

import org.springframework.stereotype.Component;
 

@Component
public class CountryDAOImpl implements CountryDAO {
static List countries = null;

static {
countries=CountryRepository.populateCountryList();
}
 
 
public List getCountries() {
 
return countries;
}
 

public Country getCountry(String countryCode) {
	//countries=CountryRepository.populateCountryList();
	for (int i=0; i < countries.size(); i++)
		
	//for (Country country: countries)
{
		Country country = (Country) countries.get(i);
if (country.getCountryCode().equals(countryCode))
{
return country;
}
}
return null;
}
 

}