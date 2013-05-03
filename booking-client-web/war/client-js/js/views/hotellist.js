window.HotelListView = Backbone.View.extend({

	initialize : function() {
		this.hotels = this.options.hotelCollection;
		this.hotels.bind("change", this.render, this);
		this.hotels.bind("destroy", this.render, this);
	},

	render : function() {
		var len = this.hotels.length;
		var itemsByLine = 4;
		var nbLines = Math.ceil( len / itemsByLine );
		
		$(this.el).html(new Paginator().render().el);
		
		for ( var i = 1; i <= nbLines; i++) {
			$(this.el).append($("<ul>").addClass("thumbnails l"+i));
			
			for ( var j = ((i-1)*itemsByLine); j < (i*itemsByLine); j++) {
				if (j < len)
				$('.l'+i, this.el).append(new HotelListItemView({
					model : this.hotels.models[j]
				}).render().el);
			}
		}

		return this;
	}
});

// One hotel item
window.HotelListItemView = Backbone.View.extend({

	tagName : "li",
	className : "span2 center",

	initialize : function() {
		this.model.bind("change", this.render, this);
		this.model.bind("destroy", this.close, this);
	},

	events : {
		"click .remove" : "removeItem"
	},

	removeItem : function() {
		this.model.destroy();
	},

	render : function() {
		var data = this.model.toJSON();
		data["stars"] = [];
		for ( var i = 0; i < this.model.get("numberOfStars"); i++) {
			data["stars"].push(i);
		}

		$(this.el).html(this.template(data));

		var imageURI = this.model.toJSON().image ? ""
				+ this.model.toJSON().image.value : "/img/hotel.png";

		$(this.el).find(".img-polaroid").attr("src", imageURI);
		
		return this;
	}

});