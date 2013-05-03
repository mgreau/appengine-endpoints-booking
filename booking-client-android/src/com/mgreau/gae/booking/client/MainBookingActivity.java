package com.mgreau.gae.booking.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.appspot.api.services.bookingendpoint.Bookingendpoint;
import com.appspot.api.services.bookingendpoint.model.CollectionResponseHotel;
import com.appspot.api.services.bookingendpoint.model.Hotel;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;

public class MainBookingActivity extends Activity {

	final HttpTransport transport = AndroidHttp.newCompatibleTransport();
	final JsonFactory jsonFactory = new JacksonFactory();
	Bookingendpoint service;
	private ListView listView = null;
	private Button buttonMore;
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private String nextPageToken = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_booking);
		
		listView = (ListView) findViewById(R.id.hotelsListView);
		buttonMore = new Button(this);
		buttonMore.setText("Plus...");
		listView.addFooterView(buttonMore);
		
		// listening to single list item on click
		listView.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
 
              // selected item
              Hotel hotel = hotels.get(position);
              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getApplicationContext(), HotelActivity.class);
              // sending data to new activity
              i.putExtra("hotel", String.valueOf(hotel.getId()));
              startActivity(i);
 
          }
        });
		
		buttonMore.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        // Starting a new async task
		    	new HotelsTask(view.getContext()).execute();
		    }
		});
		
		service = new Bookingendpoint(transport, jsonFactory, null);
		
		listHotels();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_booking, menu);
		return true;
	}
	
	private void listHotels() {
		nextPageToken = null;
		new HotelsTask(this).execute();
	}

	private class HotelsTask extends AsyncTask<Void, Void, String> {
		Context context;
		
		public HotelsTask(Context context) {
			this.context = context;
		}

		protected String doInBackground(Void... unused) {			
			try {
				//dashboard = service.dashboard().execute();
				com.appspot.api.services.bookingendpoint.Bookingendpoint.Hotels.List list = service.hotels().list();
				list.setLimit(20);
				if(nextPageToken != null && !nextPageToken.isEmpty()) {
					list.setCursor(nextPageToken);
				}
				CollectionResponseHotel collectionResponseHotel = list.execute();
				
				hotels.addAll(collectionResponseHotel.getItems());
				nextPageToken = collectionResponseHotel.getNextPageToken();
			} catch (IOException e) {
				Log.d("Booking Client Endpoints", e.getMessage(), e);
			}
			return nextPageToken;
		}

		@Override
		protected void onPostExecute(String nextPageToken) {
			TextView textNbHotels = (TextView) findViewById(R.id.nbHotels);
						
			textNbHotels.setVisibility(View.GONE);
			
			// get listview current position - used to maintain scroll position
            int currentPosition = listView.getFirstVisiblePosition();
			
			listView.setAdapter(new HotelAdapter(context, hotels));			
			
			// Setting new scroll position
			listView.setSelectionFromTop(currentPosition + 1, 0);
		}
	}

}
