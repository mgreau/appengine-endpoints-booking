package com.mgreau.gae.booking.client;

import java.io.IOException;

import com.appspot.api.services.bookingendpoint.Bookingendpoint;
import com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel;
import com.appspot.api.services.bookingendpoint.model.Hotel;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class HotelActivity extends Activity {
	
	final HttpTransport transport = AndroidHttp.newCompatibleTransport();
	final JsonFactory jsonFactory = new JacksonFactory();
	Bookingendpoint service;
	
	public ImageLoader imageLoader; 
	
	private String hotelId = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.hotel_detail);
 
        service = new Bookingendpoint(transport, jsonFactory, null);
        
        imageLoader = new ImageLoader(this.getApplicationContext());
        
        Intent i = getIntent();
        // getting attached intent data
        hotelId = i.getStringExtra("hotel");
        
        new HotelTask(this).execute();
 
    }
    
	private class HotelTask extends AsyncTask<Void, Void, Void> {
		Context context;
		private Hotel hotel;
		
		public HotelTask(Context context) {
			this.context = context;
		}

		protected Void doInBackground(Void... unused) {			
			try {
				com.appspot.api.services.bookingendpoint.Bookingendpoint.Hotels.Get get = service.hotels().get(hotelId);
				hotel = get.execute();
			} catch (IOException e) {
				Log.d("Booking Client Endpoints", e.getMessage(), e);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			TextView hotelLabel = (TextView) findViewById(R.id.hotelLabel);
			TextView hotelAddress = (TextView) findViewById(R.id.hotelAddress);
			TextView hotelCity = (TextView) findViewById(R.id.hotelCity);
			
			LinearLayout stars = (LinearLayout) findViewById(R.id.hotelStars);
			
			for(int i=1; i<=hotel.getNumberOfStars(); i++) {
				ImageView starImage = new ImageView(context);
				starImage.setImageResource(R.drawable.star);
				stars.addView(starImage);
			}
			
			ImageView imageView = (ImageView) findViewById(R.id.imageHotelDetail);
	        
			hotelLabel.setText(hotel.getHotelName());
			hotelAddress.setText(hotel.getAddress());
			hotelCity.setText(hotel.getCity() + ", " + hotel.getCountry() + " - " + hotel.getPrice() + " Euros -");
			imageLoader.DisplayImage(hotel.getImage().getValue(), imageView);
		}
	}
}
