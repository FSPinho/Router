package br.router.maps.model;

public class DirectionsLocation {
	
	String name = null;
	private Double lat = null;
	private Double lng = null;
	
	public DirectionsLocation() {
		
	}
	
	public DirectionsLocation(Double latitude, Double longitude) {
		this.lat = latitude;
		this.lng = longitude;
	}
	
	public DirectionsLocation(String name) {
		super();
		this.name = name;
	}

	public DirectionsLocation(String name, Double lat, Double lng) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}
	
	public void setLat(double latitude) {
		this.lat = latitude;
	}
	
	public double getLng() {
		return lng;
	}
	
	public void setLng(double longitude) {
		this.lng = longitude;
	}
	
	@Override
	public String toString() {
		if(lat == null || lng == null)
			return name;
		else 
			return lat + "," + lng;
	}
		
}
