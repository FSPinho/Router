package br.router.maps.model;

public class DirectionsStep {
	private DirectionsLocation start_location;
	private DirectionsLocation end_location;
	
	public DirectionsStep() {
		
	}

	public DirectionsLocation getStart_location() {
		return start_location;
	}

	public void setStart_location(DirectionsLocation start_location) {
		this.start_location = start_location;
	}

	public DirectionsLocation getEnd_location() {
		return end_location;
	}

	public void setEnd_location(DirectionsLocation end_location) {
		this.end_location = end_location;
	}
	
	
}
