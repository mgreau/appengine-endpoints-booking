window.BookingListView = Backbone.View.extend({
	
	initialize : function() {
		gapi.client.bookingendpoint.hotels.bookings.listByUser().execute(
				function(resp) {
					app.bookingListView.render(resp.result);
				});
	},

	render : function(datas) {
		if (datas && datas.items) {
			var len = datas.items.length;

			$(this.el).html($("<ul>").addClass("media-list"));

			for ( var i = 0; i < len; i++) {
				$('.media-list', this.el).append(
					new BookingListItemView(datas.items[i]).render().el);
			}
		}else{
			$(this.el).html($("<p>Aucune réservation.</p>"));
		}

		return this;
	},

	refresh : function() {
		  gapi.client.bookingendpoint.hotels.bookings.listByUser().execute(
		 function(resp) { app.bookingListView.render(resp.result); });
	}
});

// One booking item
window.BookingListItemView = Backbone.View.extend({
	
	initialize : function(booking) {
		this.data = booking;
	},

	events : {
		"click .remove" : "removeItem",
		"click .details" : "showHotel",
	},

	removeItem : function() {
		gapi.client.bookingendpoint.hotels.bookings.delete({
			hotelId : this.data['hotelId'], bookingId : this.data['id']
		}).execute(function(resp) {
			if (!resp.code){
				utils.createAlert('Success!', 'Votre réservation a été annulée.', 'alert-success');
				app.bookingListView.refresh();
			}
		});
	},
	
	showHotel : function() {
		gapi.client.bookingendpoint.hotels.get({
			id : this.data['hotelId']}).execute(function(resp) {
			if (!resp.code){
				$('#booking-hotel'+resp.result.id).html(
						new BookingListItemHotelView(resp.result).render().el);
				app.navigate("", false);
			}
		});
	},

	render : function() {
		var tmpDate = new Date(this.data["checkoutDate"]);
		tmpDate = tmpDate.format("d/m/yyyy");
		this.data["checkoutDate"] = tmpDate;
		var tmpDate2 = new Date(this.data["checkinDate"]);
		tmpDate2 = tmpDate2.format("d/m/yyyy");
		this.data["checkinDate"] = tmpDate2;
		$(this.el).html(this.template(this.data));
		
		return this;
	},
	
});

window.BookingListItemHotelView = Backbone.View.extend({
	
	initialize : function(data) {
		this.data = data;
	},
	
	render : function() {
		$(this.el).html(this.template(this.data));
		return this;
	},
	
});
