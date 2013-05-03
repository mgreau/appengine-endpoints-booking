package com.mgreau.gae.booking.client;

import java.util.List;

import com.appspot.api.services.bookingendpoint.model.Hotel;

public class HotelList {

	private List<Hotel> hotels;
	
	private String nextCursor;
	
	private String lastCursor;

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public String getNextCursor() {
		return nextCursor;
	}

	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}

	public String getLastCursor() {
		return lastCursor;
	}

	public void setLastCursor(String lastCursor) {
		this.lastCursor = lastCursor;
	}
	

}
