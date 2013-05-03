package com.mgreau.gae.booking.client;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appspot.api.services.bookingendpoint.model.Hotel;

public class HotelAdapter extends BaseAdapter {

	private final Context context;
	private List<Hotel> hotels;
	
	public ImageLoader imageLoader; 

	public HotelAdapter(Context context, List<Hotel> hotels) {
		super();
		this.context = context;
		this.hotels = hotels;
		
		imageLoader=new ImageLoader(context.getApplicationContext());
	}

	@Override
	public int getCount() {
		return hotels.size();
	}

	@Override
	public Object getItem(int index) {
		return hotels.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.booking_hotel_item, parent, false);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imageHotel);
		TextView hotelNameTextView = (TextView) rowView.findViewById(R.id.textHotelName);
		TextView hotelCityTextView = (TextView) rowView.findViewById(R.id.textHotelCity);
		
		Hotel hotel = hotels.get(position);
		hotelNameTextView.setText(hotel.getHotelName());
		hotelCityTextView.setText(hotel.getCity() + ", " + hotel.getCountry());
		
		imageLoader.DisplayImage(hotel.getImage().getValue(), imageView);
//		if(hotel.getImage() != null && hotel.getImage().getValue() != null) {
//			byte[] decodedString = Base64.decode(hotel.getImage().getValue(), Base64.DEFAULT);
//			Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//			imageView.setImageBitmap(decodedByte);
//		}

		return rowView;
	}

}
