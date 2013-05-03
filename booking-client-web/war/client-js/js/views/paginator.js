window.Paginator = Backbone.View.extend({

    className: "pagination pagination-centered",

    initialize:function () {
        this.render();
    },

    render:function () {

        $(this.el).html($("<ul>").addClass("nextprevious"));
        if (app.cursor){
        	$('.nextprevious', this.el).append('<li><a href=#hotels/cursor/'+ app.cursor +'><span>Hôtels suivants >></span></a></li>');
        }
        	
        return this;
    }
});