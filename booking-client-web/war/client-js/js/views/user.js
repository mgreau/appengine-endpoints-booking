window.UserView = Backbone.View
		.extend({

			initialize : function() {
				$(this.el)
						.html(
								"<p class=help-block>Connectez-vous pour voir vos réservations !</p>");

				if (app.user) {
					this.render(app.user);
				}else{
					var authorizeButton = document.getElementById('authorize-button');
					authorizeButton.style.visibility = '';
					authorizeButton.onclick = handleAuthClick;
					$('#bookings-content').html('');
				}
			},

			events : {
				"click #logout-btn" : "logout",
			},

			render : function(data) {
				if (typeof data.picture == 'undefined'){
					data['picture'] = ['/img/silhouette96.png'];
				}
				$(this.el).html(this.template(data));
				if (data != null) {
					app.bookingListView = new BookingListView();
					$('#bookings-content').html(app.bookingListView.el);
				}
				return this;
			},

			// todo
			logout : function() {
				app.user = null;
				this.initialize();
				app.navigate("logout", false);
			}

		});