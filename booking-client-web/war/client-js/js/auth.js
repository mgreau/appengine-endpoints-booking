var clientId = '961575813955-so0anb7ag4128gi92343k6im3anaksf3.apps.googleusercontent.com';
var apiKey = 'AIzaSyCGwfK4SHgaDQQVMSUXGJBW5-umB0_Di-8';
var scopes = [ "https://www.googleapis.com/auth/userinfo.email",
		"https://www.googleapis.com/auth/userinfo.profile" ];

function loadGapi() {
	gapi.client.load('bookingendpoint', 'v1', function() {
	}, 'https://cloud-booking.appspot.com/_ah/api');
	gapi.client.load('oauth2', 'v2', function() {
		checkAuth();
	});
}

function checkAuth() {
	gapi.auth.authorize({
		client_id : clientId,
		scope : scopes,
		immediate : true,
		response_type : 'token id_token'
	}, handleAuthResult);
}

function handleAuthResult(authResult) {
	var authorizeButton = document.getElementById('authorize-button');
	if (authResult) {
		authorizeButton.style.visibility = 'hidden';
		makeApiCall();
	} else {
		authorizeButton.style.visibility = '';
		authorizeButton.onclick = handleAuthClick;
		app.initDatas();
	}
}

function handleAuthClick(event) {
	gapi.auth.authorize({
		client_id : clientId,
		scope : scopes,
		immediate : false
	}, handleAuthResult);
	return false;
}

function makeApiCall() {
	var request = gapi.client.oauth2.userinfo.get().execute(function(resp) {
		if (!resp.code) {
			var token = gapi.auth.getToken();
				token.access_token = token.id_token;
				gapi.auth.setToken(token);
			app.user = resp.result;
			app.initDatas();
		}
	});
}
