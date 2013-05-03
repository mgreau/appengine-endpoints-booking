package com.mgreau.gae.booking;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

@Api(name = "bookingendpoint", clientIds = { Ids.CLIENT_ID }, audiences = { Ids.AUDIENCE })
public class BookingEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method.
	 * 
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	@ApiMethod(name = "hotels.bookings.list", path = "hotels/{hotelId}/bookings")
	public List<Booking> listBooking(@Named("hotelId") Long hotelId) {
		EntityManager mgr = getEntityManager();
		List<Booking> result = new ArrayList<Booking>();
		try {
			Query query = mgr.createQuery(
					"select from Booking as Booking where hotelId = :id")
					.setParameter("id", hotelId);
			for (Object obj : (List<Object>) query.getResultList()) {
				result.add(((Booking) obj));
			}
			for (Booking b : result)
				;
		} finally {
			mgr.close();
		}
		return result;
	}

	/**
	 * This method lists all bookings for a user. It uses HTTP GET method.
	 * 
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	@ApiMethod(name = "hotels.bookings.listByUser", path = "hotels/bookings/user")
	public List<Booking> listBookingByUser(User user) throws UnauthorizedException {
		if (user == null) {
			throw new UnauthorizedException("missing user");
		}
		EntityManager mgr = getEntityManager();
		List<Booking> result = new ArrayList<Booking>();
		try {
			Query query = mgr.createQuery(
					"select from Booking as b where user = :userLogin " + "")
					.setParameter("userLogin", user);
			for (Object obj : (List<Object>) query.getResultList()) {
				result.add(((Booking) obj));
			}
			// Tight loop for fetching all entities from datastore and
			// accommodate
			// for lazy fetch
			for (Booking b : result)
				;
		} finally {
			mgr.close();
		}
		return result;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "hotels.bookings.get", path = "hotels/bookings/{id}")
	public Booking getBooking(@Named("id") Long id, User user)
			throws UnauthorizedException {
		if (user == null) {
			throw new UnauthorizedException("missing user");
		}
		EntityManager mgr = getEntityManager();
		Booking booking = null;
		try {
			booking = mgr.find(Booking.class, id);
		} finally {
			mgr.close();
		}
		return booking;
	}

	/**
	 * This inserts the entity into App Engine datastore. It uses HTTP POST
	 * method.
	 * 
	 * @param booking
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "hotels.bookings.insert", path = "hotels/{hotelId}/bookings")
	public Booking insertBooking(@Named("hotelId") Long hotelId,
			Booking booking, User user) throws UnauthorizedException {
		if (user == null) {
			throw new UnauthorizedException("missing user");
		}
		booking.setUser(user);
		booking.setHotelId(hotelId);
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(booking);
		} finally {
			mgr.close();
		}
		return booking;
	}

	/**
	 * This method is used for updating a entity. It uses HTTP PUT method.
	 * 
	 * @param booking
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "hotels.bookings.update", path = "hotels/{hotelId}/bookings")
	public Booking updateBooking(@Named("hotelId") Long hotelId,
			Booking booking, User user) throws UnauthorizedException {
		if (user == null) {
			throw new UnauthorizedException("missing user");
		}
		booking.setUser(user);
		booking.setHotelId(hotelId);
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(booking);
		} finally {
			mgr.close();
		}
		return booking;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	@ApiMethod(name = "hotels.bookings.delete", path = "hotels/{hotelId}/bookings/{bookingId}")
	public Booking removeBooking(@Named("hotelId") Long hotelId,
			@Named("bookingId") Long id, User user)
			throws UnauthorizedException {
		if (user == null) {
			throw new UnauthorizedException("missing user");
		}
		EntityManager mgr = getEntityManager();
		Booking booking = null;
		try {
			booking = mgr.find(Booking.class, id);
			mgr.remove(booking);
		} finally {
			mgr.close();
		}
		return booking;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
