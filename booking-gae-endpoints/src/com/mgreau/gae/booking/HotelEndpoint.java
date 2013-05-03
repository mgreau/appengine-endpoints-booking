package com.mgreau.gae.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Field;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import com.google.appengine.api.search.SearchServiceFactory;
import com.google.appengine.datanucleus.query.JPACursorHelper;

@Api(name = "bookingendpoint", clientIds = { Ids.CLIENT_ID }, audiences = { Ids.AUDIENCE })
public class HotelEndpoint {

	static final Index INDEX = getIndex();

	private static Index getIndex() {
		IndexSpec indexSpec = IndexSpec.newBuilder().setName("hotelindex")
				.build();
		return SearchServiceFactory.getSearchService().getIndex(indexSpec);
	}

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method.
	 * 
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	@ApiMethod(name = "hotels.list")
	public CollectionResponse<Hotel> listHotel(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {
		EntityManager mgr = getEntityManager();
		List<Hotel> result = null;
		Cursor cursor = null;
		// To check if its the latest cursor
		String backupCursor = cursorString;
		try {
			Query query = mgr.createQuery("select from Hotel as Hotel");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}
			if (limit != null) {
				query.setMaxResults(limit);
			}
			result = (List<Hotel>) query.getResultList();
			cursor = JPACursorHelper.getCursor(result);
			if (cursor != null && result != null && limit != null
					&& result.size() == limit)
				cursorString = cursor.toWebSafeString();
			else
				cursorString = "";

			if (cursorString != null && backupCursor != null
					&& backupCursor.equals(cursorString)) {
				cursorString = "";
			}
			// Tight loop for fetching all entities from datastore and
			// accomodate
			// for lazy fetch.
			for (@SuppressWarnings("unused")
			Hotel h : result)
				;
		} finally {
			mgr.close();
		}
		return CollectionResponse.<Hotel> builder().setItems(result)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "hotels.get")
	public Hotel getHotel(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Hotel hotel = null;
		try {
			hotel = mgr.find(Hotel.class, id);
		} finally {
			mgr.close();
		}
		return hotel;
	}

	/**
	 * This inserts the entity into App Engine datastore. It uses HTTP POST
	 * method.
	 * 
	 * @param hotel
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "hotels.insert")
	public Hotel insertHotel(Hotel hotel) {
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(hotel);
		} finally {
			mgr.close();
		}
		addHotelToSearchIndex(hotel);
		return hotel;
	}

	/**
	 * This method is used for updating a entity. It uses HTTP PUT method.
	 * 
	 * @param hotel
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "hotels.update")
	public Hotel updateHotel(Hotel hotel) {
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(hotel);
		} finally {
			mgr.close();
		}
		addHotelToSearchIndex(hotel);
		return hotel;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	@ApiMethod(name = "hotels.delete")
	public Hotel removeHotel(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Hotel hotel = null;
		try {
			hotel = mgr.find(Hotel.class, id);
			mgr.remove(hotel);
		} finally {
			mgr.close();
		}
		return hotel;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

	@ApiMethod(httpMethod = "GET", name = "hotels.search")
	public List<Hotel> searchHotel(@Named("term") String queryString) {

		List<Hotel> hotelList = new ArrayList<Hotel>();
		Results<ScoredDocument> results = INDEX.search(queryString);

		for (ScoredDocument scoredDoc : results) {
			Field f = scoredDoc.getOnlyField("id");
			if (f == null || f.getText() == null)
				continue;

			long hotelId = Long.parseLong(f.getText());
			if (hotelId != -1) {
				Hotel b = getHotel(hotelId);
				hotelList.add(b);
			}
		}
		return hotelList;
	}

	private static void addHotelToSearchIndex(Hotel h) {
		Document.Builder docBuilder = Document
				.newBuilder()
				.addField(
						Field.newBuilder()
								.setName("name")
								.setText(
										h.getHotelName() != null ? h
												.getHotelName() : ""))
				.addField(
						Field.newBuilder().setName("id")
								.setText(Long.toString(h.getId())))
				.addField(
						Field.newBuilder()
								.setName("country")
								.setText(
										h.getCountry() != null ? h.getCountry()
												: ""))
				.addField(
						Field.newBuilder()
								.setName("price")
								.setNumber(
										h.getPrice() != null ? h.getPrice() : 0))
				.addField(
						Field.newBuilder()
								.setName("city")
								.setText(h.getCity() != null ? h.getCity() : ""))
				.addField(
						Field.newBuilder()
								.setName("numberOfStars")
								.setNumber(
										h.getNumberOfStars() != null ? h
												.getNumberOfStars() : 0))
				.addField(
						Field.newBuilder().setName("published")
								.setDate(Field.date(new Date())));
		docBuilder.setId(Long.toString(h.getId()));
		Document doc = docBuilder.build();
		INDEX.put(doc);
	}

}
