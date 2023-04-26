package com.camel.service.controllerservice.lookup;

import java.util.ArrayList;
import java.util.List;

public class CountryRepository {

	public static List countries;
	 
	public static List populateCountryList()
	{
		System.out.println("INside populate country list");
		countries=new ArrayList();
	 
		countries.add(new Country("IND", "India", "Rupee"));
		countries.add(new Country("US", "USA", "Dollar"));

	return countries;
	}
	
}
