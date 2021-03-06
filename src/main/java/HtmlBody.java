
public class HtmlBody {
	private static final String GoogleMapApiCredential = "AIzaSyDHHv0j7SbSzYsWyTdEc38uAl9Ek0nfTM4";

	public static String getResponse(String geodata) {
		String htmlBody = "<!DOCTYPE html><html><head><title>Cattle GPS Locations</title><meta name='viewport' content='initial�scale=1.0, user�scalable=no'><meta charset='utf�8'><style>html, body {height: 100%;margin: 0;padding: 0;}#map {height: 100%;}</style></head><body><div id='map'></div><script>function initMap() {var map = new google.maps.Map(document.getElementById('map'), { center: {lat: 48.055, lng: 8.18}, zoom: 10 });var infoWindow = new google.maps.InfoWindow({map: map});if (navigator.geolocation) {navigator.geolocation.getCurrentPosition(function(position) {var pos = {lat: position.coords.latitude,lng: position.coords.longitude};infoWindow.setPosition(pos);infoWindow.setContent('Location found.');map.setCenter(pos);}, function() {handleLocationError(true, infoWindow, map.getCenter());});} else {handleLocationError(false, infoWindow, map.getCenter());}var locations = ["
				+ geodata
				+ "];var infowindow = new google.maps.InfoWindow();var marker, i;for (i = 0; i < locations.length; i++) {marker = new google.maps.Marker({position: new google.maps.LatLng(locations[i][1], locations[i][2]),map: map});google.maps.event.addListener(marker, 'click', (function(marker, i) {return function() {infowindow.setContent(locations[i][0]);infowindow.open(map, marker);}})(marker, i));}}function handleLocationError(browserHasGeolocation, infoWindow, pos) {infoWindow.setPosition(pos);infoWindow.setContent(browserHasGeolocation ?'Error: The Geolocation service failed.' :'Error: Your browser does not support geolocation.');}</script><script async defer src='https://maps.googleapis.com/maps/api/js?key="
				+ GoogleMapApiCredential + "&callback=initMap'></script></body></html>";
		return htmlBody;
	}
}
