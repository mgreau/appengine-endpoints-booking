package com.mgreau.gae.booking.client;



public class SearchForm {

	private String term;
	
	private int nbResults;
	
	private int nbHotels;
	
	private String city;
	
	private String country;
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getNbResults() {
		return nbResults;
	}

	public void setNbResults(int nbResults) {
		this.nbResults = nbResults;
	}

	public int getNbHotels() {
		return nbHotels;
	}

	public void setNbHotels(int nbHotels) {
		this.nbHotels = nbHotels;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
