package com.mgreau.gae.booking.client;

import java.io.IOException;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.extensions.appengine.auth.oauth2.AppEngineCredentialStore;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.rendering.Decorated;

@Decorated
public class LoginPage extends Decorator {

	protected static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email";
	protected static final String CALLBACK_URL = "http://localhost:7777/oauth2callback";
	
	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	  private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	// FILL THESE IN WITH YOUR VALUES FROM THE API CONSOLE
	protected static final String CLIENT_ID = "961575813955-so0anb7ag4128gi92343k6im3anaksf3.apps.googleusercontent.com";
	protected static final String CLIENT_SECRET = "AsaTBnBfstp0AYAte_nJbFm5";

	/** Code retourné par Google */
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String responseLogin;

	public String getResponseLogin() {
		return responseLogin;
	}
	
	public String user;
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Get
	public void get(Request request) throws IOException {
		 if (code == null) {
			responseLogin = "Missing authorization code";
		} else {
			AuthorizationCodeFlow flow = new AuthorizationCodeFlow.Builder(
					BearerToken.authorizationHeaderAccessMethod(),
					new NetHttpTransport(), new JacksonFactory(),
					new GenericUrl("https://accounts.google.com/o/oauth2/token"),
					new BasicAuthentication(CLIENT_ID,
							CLIENT_SECRET), CLIENT_ID, CALLBACK_URL)
					.build();
			
			TokenResponse token = flow.newTokenRequest(code).setRedirectUri(CALLBACK_URL).execute();
			
			// Code Google reçu, demander le token via POST
			/*
			Web web = Guice.createInjector().getInstance(Web.class);
			WebResponse response = web
					.clientOf("https://accounts.google.com//o/oauth2/token")
					.transportsText()
					.post("code=" + code + "&client_id=" + CLIENT_ID
							+ "&client_secret=" + CLIENT_SECRET
							+ "&redirect_uri=" + CALLBACK_URL
							+ "&grant_type=authorization_code");

			GoogleTokenResponse googleResp = response.to(
					GoogleTokenResponse.class).using(Json.class);

			WebResponse apiResponse = web
					.clientOf(
							"https://www.googleapis.com/oauth2/v1/userinfo?access_token="
									+ googleResp.getAccess_token())
					.transportsText().get();
			
			user = apiResponse.toString();*/
			user=token.getAccessToken();

		}
	}
	

	protected class GoogleTokenResponse {
		String access_token;
		String expires_in;
		String token_type;
		String refresh_token;

		public String getRefresh_token() {
			return refresh_token;
		}

		public void setRefresh_token(String refresh_token) {
			this.refresh_token = refresh_token;
		}

		public String getAccess_token() {
			return access_token;
		}

		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}

		public String getExpires_in() {
			return expires_in;
		}

		public void setExpires_in(String expires_in) {
			this.expires_in = expires_in;
		}

		public String getToken_type() {
			return token_type;
		}

		public void setToken_type(String token_type) {
			this.token_type = token_type;
		}

	}
}
