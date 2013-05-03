package com.mgreau.gae.booking.client;

import java.util.List;

import com.appspot.api.services.bookingendpoint.Bookingendpoint;
import com.appspot.api.services.bookingendpoint.model.Booking;
import com.appspot.api.services.bookingendpoint.model.Dashboard;
import com.appspot.api.services.bookingendpoint.model.Hotel;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;

@At("/search") @Decorated
public class SearchResultPage extends Decorator {
	
	protected List<Hotel> hotels;
	
	protected Dashboard dashboard;

	private List<Booking> bookings;
	
	public Dashboard getDashboard() {
		return dashboard;
	}
	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
	public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Get
	public void get() {
		HttpTransport httpTransport = new NetHttpTransport();
		final JsonFactory jsonFactory = new JacksonFactory();
		Bookingendpoint service = new Bookingendpoint(httpTransport,
				jsonFactory, null);
		try {
			setDashboard(service.dashboard().execute());
			setHotels(service.hotels().search(term).execute().getItems());
		}catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Post
	public void post(){
		this.get();
	}
	


}
