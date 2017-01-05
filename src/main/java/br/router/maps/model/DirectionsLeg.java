package br.router.maps.model;

import java.util.List;

public class DirectionsLeg {
	private String start_address;
	private DirectionsLocation start_location;
	private String end_address;
	private DirectionsLocation end_location;
	
	private List<DirectionsStep> steps;
	
	public DirectionsLeg() {
		
	}

	public String getStart_address() {
		return start_address;
	}

	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}

	public DirectionsLocation getStart_location() {
		return start_location;
	}

	public void setStart_location(DirectionsLocation start_location) {
		this.start_location = start_location;
	}

	public String getEnd_address() {
		return end_address;
	}

	public void setEnd_address(String end_address) {
		this.end_address = end_address;
	}

	public DirectionsLocation getEnd_location() {
		return end_location;
	}

	public void setEnd_location(DirectionsLocation end_location) {
		this.end_location = end_location;
	}

	public List<DirectionsStep> getSteps() {
		return steps;
	}

	public void setSteps(List<DirectionsStep> steps) {
		this.steps = steps;
	}
	
}
