* Checkoout this project

* Start App Engine server

* Test your app with curl :

1. hotels list (result 0)
curl http://localhost:8888/_ah/api/bookingendpoint/v1/hotel

2. Add a hotel
curl -H 'Content-Type: application/json' -d '{"nameHotel": "Hôtel de France", "price":"120", "city":"Nantes", "country":"FRANCE" }' http://localhost:8888/_ah/api/bookingendpoint/v1/hotel

3. hotel list again
curl http://localhost:8888/_ah/api/bookingendpoint/v1/hotel

4. Get hotel with id
curl http://localhost:8888/_ah/api/bookingendpoint/v1/hotel/1