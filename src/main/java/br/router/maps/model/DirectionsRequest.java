package br.router.maps.model;

import java.util.List;

public class DirectionsRequest {

	private DirectionsLocation origin;
	private DirectionsLocation destination;
	private List<DirectionsLocation> waypoints;
	private boolean optimize;
	
	
	public DirectionsRequest() {
		
	}

	public DirectionsRequest(DirectionsLocation origin, DirectionsLocation destination, List<DirectionsLocation> waypoints, boolean optimize) {
		this.origin = origin;
		this.destination = destination;
		this.waypoints = waypoints;
		this.optimize = optimize;
	}
	

	public DirectionsLocation getOrigin() {
		return origin;
	}
	
	public void setOrigin(DirectionsLocation origin) {
		this.origin = origin;
	}
	
	public DirectionsLocation getDestination() {
		return destination;
	}
	
	public void setDestination(DirectionsLocation destination) {
		this.destination = destination;
	}
	
	public List<DirectionsLocation> getWaypoints() {
		return waypoints;
	}
	
	public void setWaypoints(List<DirectionsLocation> waypoints) {
		this.waypoints = waypoints;
	}
	
	public boolean isOptimize() {
		return optimize;
	}
	
	public void setOptimize(boolean optimize) {
		this.optimize = optimize;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "origin=" + origin;
		out += "&destination=" + destination;
		
		if(waypoints.size() > 0) {
			out += "&waypoints=optimize:" + optimize;
			for(DirectionsLocation location: waypoints) {
				out += "|" + location;
			}
		}
		return out;
	}
	
}
