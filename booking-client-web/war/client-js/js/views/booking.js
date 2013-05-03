window.BookingView = Backbone.View
		.extend({

			initialize : function() {
				this.render();
			},

			events : {
				"click #book" : "bookHotel",
			},

			bookHotel : function() {
				if (app.user) {
					var smoke = false;
					smoke = ($(this.el).find("#smoking").attr("checked") == "checked" ? true
							: false);
					gapi.client.bookingendpoint.hotels.bookings.insert(
							{
								hotelId : this.model.id,
								"checkinDate" : $(this.el).find("#checkinDate")
										.val(),
								"checkoutDate" : $(this.el).find(
										"#checkoutDate").val(),
								"description" : "it works ?",
								"smoking" : smoke,
								"beds" : $(this.el).find("#room").val()
							}).execute(function(resp) {
						console.log(resp);
						app.navigate("", false);
						if (!resp.code){
							this.app.bookingListView.refresh();
							utils.createAlert('Success',
									'Votre réservation est prise en compte.',
									'alert-success');
						}else{
							utils.createAlert('Error',
									'Un problème est survenu pendant la réservation.' + resp.code,
									'alert-error');
						}
					});
				} else {
					utils.createAlert('Error',
							'Vous devez être connecté pour réserver un hôtel.',
							'alert-error');
					app.navigate("", false);
				}

			},

			render : function() {
				var data = this.model.toJSON();
				data["stars"] = [];
				for ( var i = 0; i < this.model.get("numberOfStars"); i++) {
					data["stars"].push(i);
				}
				$(this.el).html(this.template(data));
				$('#date1', this.el).datepicker({
					format : 'yyyy-mm-dd'
				});
				$('#date2', this.el).datepicker({
					format : 'yyyy-mm-dd'
				});
				return this;
			}

		});