window.DashboardView = Backbone.View
		.extend({

			initialize : function() {
				$(this.el)
						.html(
								"<div id=front><div class=\"container\" style=\"background-color:#e5e5e5;height:85px;\">" +
								"<div class=row><div class=span9><div class=\"makesense center\">" +
								"</div></div></div></div></div>");
			},

			render : function(data) {
				$(this.el).html(this.template(data));
				return this;
			},

			loadDatas : function() {
				gapi.client.bookingendpoint.dashboard().execute(function(data) {
					this.app.dashboardView.render(data);
				});
			}

		});