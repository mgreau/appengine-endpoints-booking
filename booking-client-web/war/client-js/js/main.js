var hotels = null;
var dashboard = null;
var app = null;

var AppRouter = Backbone.Router.extend({
	
	user : null,

	routes: {
		"" : "list",
		"hotels/cursor/:cursor" : "list",
		"hotels/add"  : "addHotel",
		"hotels/:id"  : "hotelDetails",
		"hotels/book/:id"  : "book",
		"hotels/search/:term"  : "search",
		"about" : "about",
		"logout" : "logout"
	},

	initialize: function () {
		this.headerView = new HeaderView();
		this.dashboardView = new DashboardView();
		
		$('.header').html(this.headerView.el)
		$('#dashboard-content').html(this.dashboardView.el);
		
		//init app
		utils.hideAlert();
	},
	
	/* Appelé si le client gapi.client est chargé */
	initDatas: function () {
		this.dashboardView.loadDatas();
		this.userView = new UserView();
		$('#user-content').html(this.userView.el);
		this.list();
	},

	list: function(cursor) {
		if (typeof gapi.client !== 'undefined'){
			utils.hideAlert();
			app.cursor = cursor;
			$("#content").html("<div class=\"progress progress-striped active\"><div class=\"bar\" style=\"width: 40%;\"></div></div><div>Chargement en cours...</div>")
			hotels = new HotelCollection();
			hotels.fetch({
				success:_.bind(this.populate, this, cursor)
			});
		}
	},
	
    populate: function(cursor, hotels) {
        $("#content").html(new HotelListView({
            hotelCollection: hotels,
            cursor: cursor
        }).render().el);
    },
    
    search: function(term){
    	$("#content").html("<div class=\"progress progress-striped progress-success active\"><div class=\"bar\" style=\"width: 40%;\"></div></div><div>Recherche en cours...</div>")
		$("#content").append("<p>"+term+"</p>");
    
    	app.cursor = null;
    	
		hotels = new HotelCollection();
    	gapi.client.bookingendpoint.hotels.search({term: term}).execute(function(data) {
    		if (data != null && data.items != null){
	    		var hotelsResults = new HotelCollection();
	    		hotels.add(hotelsResults.parse(data.items));
    		}
    		app.searchResults(term, hotels);
        });
    	
    },
    
    searchResults: function(term, hotels) {
    	 if (hotels != null && hotels.length > 0){
    		 if (hotels.length > 1){
    			 utils.createAlert('Success!', 'Recherche pour <u>' + term + '</u><br/>' + hotels.length + ' Hôtels correspondent à vos critères.', 'alert-success');
    		 }
    		 else {
    			 utils.createAlert('Success!', 'Recherche pour <u>' + term + '</u><br/>' + hotels.length + ' Hôtel correspond à vos critères.', 'alert-success');
    		 }
    		 app.populate(null, hotels);
    	 }
    	 else{
    		 utils.createAlert('Attention!', 'Recherche pour <u>' + term + '</u><br/>' + 'Aucun hôtel ne correspond à vos critères.', 'alert-error');
    		 $("#content").html("<p>Retentez votre chance avec d'autres critères :)</p>")
    	 }
    },
    
    book: function (id) {
        if (!hotels.models.length) {
            this.navigate("", true);
            return;
        }
        
		$("#content").html(new BookingView({ model: hotels.get(id) }).el);
	},

	hotelDetails: function (id) {
        if (!hotels.models.length) {
            this.navigate("", true);
            return;
        }
        
		$("#content").html(new HotelView({ model: hotels.get(id) }).el);
	},

	addHotel: function() {
		var hotel = new Hotel();
		$('#content').html(new HotelView({
			model: hotel
		}).el);
		this.navigate("", false);
	},

	about: function () {
		if (!this.aboutView) {
			this.aboutView = new AboutView();
		}
		$('#content').html(this.aboutView.el);
	},
	
	logout: function () {
		//gapi.auth.setToken(null);
		this.user = null;
		this.navigate("logout", true);
        return;
	}
});

utils.loadTemplate(['HeaderView', 'DashboardView', 'HotelView', 'HotelListItemView', 'AboutView', 'UserView', 'BookingListItemView', 'BookingListItemHotelView' , 'BookingView'], function() {

    app = new AppRouter();
    hotels = new HotelCollection();
	Backbone.history.start();

});
