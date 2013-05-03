package com.mgreau.gae.booking.client;

import java.util.List;

import com.appspot.api.services.bookingendpoint.model.Booking;

public class BookingList {

	private List<Booking> bookings;

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

}
