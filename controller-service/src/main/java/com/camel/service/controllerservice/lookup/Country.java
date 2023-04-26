package com.camel.service.controllerservice.lookup;

public class Country {
	
	String countryCode;
	String countryDescription;
	String currency;
	
	public Country()
	{
		
	}
	
	public Country(String countryCode, String countryDescription, String currency) {
		super();
		this.countryCode = countryCode;
		this.countryDescription = countryDescription;
		this.currency = currency;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryDescription() {
		return countryDescription;
	}
	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", countryDescription=" + countryDescription + ", currency="
				+ currency + "]";
	}

}
