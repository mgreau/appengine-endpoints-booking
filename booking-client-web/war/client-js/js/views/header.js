window.HeaderView = Backbone.View.extend({

	 initialize: function () {
	        this.render();
	    },

	    events: {
	      "keydown" : "searchFromKey"
	    },

	    render: function () {
	        $(this.el).html(this.template());
	        return this;
	    },

	    searchFromKey: function(e) {
	        if (e.keyCode == 13) {
	        	this.callSearch($(this.el).find("input").val());
	        }
	        return this;
	    },
	    
	    callSearch : function (term) {
	    	app.search(term);
	    	app.navigate('#hotels/search/'+term, {trigger: false});
	    	
		}

});