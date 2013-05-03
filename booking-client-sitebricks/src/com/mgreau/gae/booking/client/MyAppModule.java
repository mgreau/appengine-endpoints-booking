package com.mgreau.gae.booking.client;

import com.google.sitebricks.SitebricksModule;

public class MyAppModule extends SitebricksModule {
    @Override
    protected void configureSitebricks() {
        at("/home").show(BookingHomePage.class);
        at("/search").show(SearchResultPage.class);
        //at("/oauth2callback").show(LoginPage.class);
        
        //embed pages
        embed(HotelList.class).as("HotelList");
        embed(BookingList.class).as("BookingList");
        embed(SearchForm.class).as("SearchForm");
    }
}