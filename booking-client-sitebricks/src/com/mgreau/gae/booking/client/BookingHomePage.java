package com.mgreau.gae.booking.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;

import com.appspot.api.services.bookingendpoint.Bookingendpoint;
import com.appspot.api.services.bookingendpoint.Bookingendpoint.Hotels.Bookings.Insert;
import com.appspot.api.services.bookingendpoint.model.Booking;
import com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel;
import com.appspot.api.services.bookingendpoint.model.Dashboard;
import com.appspot.api.services.bookingendpoint.model.Hotel;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.sitebricks.At;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;

@At("/home") @Decorated
public class BookingHomePage extends Decorator {
	
protected Dashboard dashboard;
	
	protected List<Hotel> hotels;

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
	
	private Credential credential;
	

	
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	@Get
	public void get(HttpServletRequest req) {
		
		HttpTransport httpTransport = new NetHttpTransport();
		final JsonFactory jsonFactory = new JacksonFactory();
		Bookingendpoint service = new Bookingendpoint(httpTransport,
				jsonFactory, null);
		try {
			setDashboard(service.dashboard().execute());
			com.appspot.api.services.bookingendpoint.Bookingendpoint.Hotels.List list = service.hotels().list().setLimit(5);
			if (cursor != null)
				list.setCursor(cursor);
			CollectionResponseHotel collection = list.execute();
			setHotels(collection.getItems());
			cursor = collection.getNextPageToken();
			
			//if (getHotels() != null && !getHotels().isEmpty())
			//bookings = service.hotels().bookings().list(getHotels().get(0).getId() +"").execute().getItems();
		}catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Post
	public void post(){
	}

	public List<Booking> getBookings() {
		return bookings;
	}
	
	private String cursor;
	
	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	public String getCursor() {
		return cursor;
	}
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
}
