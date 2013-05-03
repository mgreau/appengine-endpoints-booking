package com.mgreau.gae.booking.client;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Booking_client_webServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
