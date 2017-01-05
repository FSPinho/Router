package br.router.maps.model;

import java.util.List;

public class DirectionsResponse {
	private List<DirectionsRoute> routes;
	
	public DirectionsResponse() {
		
	}

	public List<DirectionsRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<DirectionsRoute> routes) {
		this.routes = routes;
	}
	
}
