package com.mgreau.gae.booking.client;

import com.google.sitebricks.Show;

@Show ("Template.html")
abstract class Decorator{
	
	String online = "https://cloud-booking-client.appspot.com/oauth2callback";
	String offline = "http://localhost:7777/oauth2callback";
	
	
	public String getLoginURL(){
		String endpoint = "https://accounts.google.com/o/oauth2/auth?"
		+ "response_type=code"
				+ "&client_id="+ LoginPage.CLIENT_ID
				+ "&redirect_uri=" + online
				+ "&scope="+ "https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile"
		+ "&approval_prompt="+ "force"
				;
		
		return endpoint;
	}
	
	
	
}