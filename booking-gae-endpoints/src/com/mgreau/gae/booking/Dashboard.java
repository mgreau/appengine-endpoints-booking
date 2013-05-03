package com.mgreau.gae.booking;

import java.util.List;

public class Dashboard {
	
	private Integer nbHotels;
	
	private List<String> countryList;
	
	private List<String> cityList;
	
	public List<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public Integer getNbHotels() {
		return nbHotels;
	}

	public void setNbHotels(Integer nbHotels) {
		this.nbHotels = nbHotels;
	}
	
}
