package com.mgreau.gae.booking.client;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;

import com.appspot.api.services.bookingendpoint.Bookingendpoint;
import com.appspot.api.services.bookingendpoint.Bookingendpoint.Hotels.Bookings.Insert;
import com.appspot.api.services.bookingendpoint.model.Booking;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.MemoryCredentialStore;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpRequest;
import com.google.api.client.http.json.JsonHttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class BookingOAuth2CallbackServlet extends AbstractAuthorizationCodeCallbackServlet {
	
	 private static final Logger log = Logger.getLogger(BookingOAuth2CallbackServlet.class.getName());
	
	@Override
	  protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
	    Log.debug(req.getAttribute("user_id") + "/" + req.getParameter("user_id"));
		return req.getParameter("user_id");
	  }

  @Override
  protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
      throws ServletException, IOException {
	  HttpTransport httpTransport = new NetHttpTransport();
		final JsonFactory jsonFactory = new JacksonFactory();
	  Bookingendpoint serviceCredentials = new Bookingendpoint(httpTransport,
				jsonFactory, credential);
	  serviceCredentials =  new Bookingendpoint.Builder(httpTransport, jsonFactory, null).setJsonHttpRequestInitializer( new JsonHttpRequestInitializer() {
	      public void initialize(JsonHttpRequest jsonHttpRequest) {
	        jsonHttpRequest.setEnableGZipContent(true);
	      }
	  }).build();
	 String insertBooking = "ok";
		try {
			Booking b = new Booking();
			b.setBeds(12);
			Insert insert = serviceCredentials.hotels().bookings().insert("15013", b);
			insert.execute();
		} catch (IOException e) {
			insertBooking = "ko";
			System.out.println("erreur booking"+e.getMessage());
		}
    resp.sendRedirect("/home?insertBooking="+insertBooking);
  }

  @Override
  protected void onError(
      HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
      throws ServletException, IOException {
	  
    // handle error
	  log.severe("erreur de connexon OAuth2");
  }

  @Override
  protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
    GenericUrl url = new GenericUrl(req.getRequestURL().toString());
    url.setRawPath("/oauth2callback");
    return url.build();
  }

  @Override
	protected AuthorizationCodeFlow initializeFlow() throws IOException {
//	  GoogleClientSecrets secret = new GoogleClientSecrets().load(jsonFactory, inputStream);
//	  AuthorizationCodeFlow f = new GoogleAuthorizationCodeFlow.Builder(
//			  new UrlFetchTransport(),
//				new JacksonFactory(),
//				 new GenericUrl("https://server.example.com/token"),
//			        new BasicAuthentication(LoginPage.CLIENT_ID, LoginPage.CLIENT_SECRET),
//			        LoginPage.CLIENT_ID,
//			        "https://server.example.com/authorize"),
//				Collections
//						.singleton("https://www.googleapis.com/auth/userinfo.email"))
//				.setCredentialStore(new MemoryCredentialStore()).build();
//	  
//	  return f;
	  return new AuthorizationCodeFlow.Builder(BearerToken.authorizationHeaderAccessMethod(),
		        new NetHttpTransport(),
		        new JacksonFactory(),
		        new GenericUrl(GoogleOAuthConstants.TOKEN_SERVER_URL),
		        new BasicAuthentication(LoginPage.CLIENT_ID, LoginPage.CLIENT_SECRET),
		        LoginPage.CLIENT_ID,
		        GoogleOAuthConstants.AUTHORIZATION_SERVER_URL).setCredentialStore(
		        new MemoryCredentialStore())
		        .build();
	}
}