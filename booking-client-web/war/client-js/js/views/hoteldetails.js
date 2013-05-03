window.HotelView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));

        this.image = $(this.el).find(".img-polaroid");
        if (this.model.get("image").value != null){
        	this.image.attr("src", this.model.get("image").value);
        }

        return this;
    },

    events: {
        "change"        : "change",
        "click .save"   : "beforeSave",
        "click .delete" : "deleteHotel",
        "dragenter .hotel-selector" : "preventDefault",
        "dragexit .hotel-selector" : "preventDefault",
        "dragover .hotel-selector" : "preventDefault",
        "drop .hotel-selector" : "dropHandler",
    },

    preventDefault: function(event) {
        event.stopPropagation();
        event.preventDefault();
    },

    change: function (event) {
        // Remove any existing alert message
        utils.hideAlert();

        // Apply the change to the model
        var target = event.target;
        var change = {};
        change[target.name] = target.value;
        this.model.set(change);

        // Run validation rule (if any) on changed item
        var check = this.model.validateItem(target.id);
        if (check.isValid === false) {
            utils.addValidationError(target.id, check.message);
        } else {
            utils.removeValidationError(target.id);
        }
    },

    beforeSave: function () {
        var self = this;
        var check = this.model.validateAll();
        if (check.isValid === false) {
            utils.displayValidationErrors(check.messages);
            return false;
        }
        this.saveHotel();

        return false;
    },
    
    saveHotel: function () {
        var self = this;
        this.model.save(null, {
            success: function (model) {
                //self.render();
                app.navigate('', false);
                utils.showAlert('Success!', 'Hotel details were saved successfully.', 'alert-success');

            },
            error: function () {
                utils.showAlert('Error', 'An error occurred while trying to delete this item', 'alert-error');
            }
        });
        return false;
    },

    deleteHotel: function () {
        this.model.destroy({
            success: function () {
                app.navigate("", false);
            }
        });
        return false;
    },

    dropHandler: function (event) {
        event.stopPropagation();
        event.preventDefault();

        var e = event.originalEvent;
        e.dataTransfer.dropEffect = 'copy';
        this.pictureFile = e.dataTransfer.files[0];

        var reader = new FileReader();
        reader.onloadend = _.bind(function () {
            this.image.attr('src', reader.result);

            this.model.set("image", { value : reader.result.split(",")[1] });
        }, this);

        reader.readAsDataURL(this.pictureFile);
    }

});