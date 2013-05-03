package com.mgreau.gae.booking;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.ListRequest;
import com.google.appengine.api.search.ListResponse;

@SuppressWarnings("serial")
public class Booking_devfest_cloudendpointsServlet extends HttpServlet {

	static Logger LOG = Logger.getLogger("logCE");

	private static final String HOTELS = "datas/hotels_devfest.csv";

	private static final String APP_NAME = "Cloud Booking";

	private static final String BASE_URL = "https://cloud-booking.appspot.com/img/";

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");

		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream(HOTELS);
		initDatas(resp.getWriter(), in);

	}

	/**
	 * Add datas (hotels, bookings), if datastore is empty.
	 */
	private void initDatas(PrintWriter w, InputStream in) {
		HotelEndpoint he = new HotelEndpoint();
		DashboardEndpoint dash = new DashboardEndpoint();

		w.println("...Check datas......");
		int datas = dash.getDashboard().getNbHotels();

		if (datas == 0) {
			//clean index
			removeIndex();
			// create hotels
			w.println("...Adding hotels......");
			Scanner lineScan = new Scanner(in);
			while (lineScan.hasNextLine()) {
				Scanner s = new Scanner(lineScan.nextLine());
				s.useDelimiter(";");
				while (s.hasNext()) {
					Hotel h1 = new Hotel();
					h1.setCountry(s.next());
					h1.setState(s.next());
					h1.setCity(s.next());
					h1.setHotelName(s.next());
					h1.setAddress(s.next());
					h1.setZip(s.next());
					int stars = new Random().nextInt(5);
					h1.setNumberOfStars(stars);
					if (stars > 0)
					h1.setPrice(new Long(new Random().nextInt((40 * stars))
							+ ""));
					else
						h1.setPrice(new Long(new Random().nextInt(35)
								+ ""));
					h1.setImage(new Text(BASE_URL + "hotel"
							+ new Random().nextInt(29) + ".jpg"));
					he.insertHotel(h1);
				}
			}
		} else {
			w.println("...Hotels already added (" + datas + " hotels)......");
			w.println("...City list (" + dash.getDashboard().getCityList()
					+ " )......");
			w.println("...Country list ("
					+ dash.getDashboard().getCountryList() + " )......");
		}
	}

	/**
	 * Clean Index before insert tests datas
	 */
	private void removeIndex() {

		try {
			while (true) {
				List<String> docIds = new ArrayList<String>();
				// Return a set of document IDs.
				ListRequest request = ListRequest.newBuilder().build();
				ListResponse<Document> response = HotelEndpoint.INDEX
						.listDocuments(request);
				if (response.getResults().isEmpty()) {
					break;
				}
				for (Document doc : response) {
					docIds.add(doc.getId());
				}
				HotelEndpoint.INDEX.remove(docIds);
			}
		} catch (RuntimeException e) {
			LOG.log(Level.SEVERE, "Failed to remove documents", e);
		}
	}
}
