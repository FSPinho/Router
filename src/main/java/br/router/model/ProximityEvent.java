package br.router.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

public class ProximityEvent {
	@Id
	private BigInteger id;
	
	@JsonIdentityReference(alwaysAsId = true)
	private Vehicle vehicle;
	
	private Long timestamp;
	
	private String message;

	public ProximityEvent() {
		
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
