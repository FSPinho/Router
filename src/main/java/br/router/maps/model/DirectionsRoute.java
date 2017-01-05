package br.router.maps.model;

import java.util.List;

public class DirectionsRoute {
	private List<DirectionsLeg> legs;
	
	public DirectionsRoute() {
		
	}

	public List<DirectionsLeg> getLegs() {
		return legs;
	}

	public void setLegs(List<DirectionsLeg> legs) {
		this.legs = legs;
	}
		
}
