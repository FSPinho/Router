package br.router.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Route {
	
	@Id
	private BigInteger id;
	
	private String name;
	
	private Long timestamp;
	
	@JsonIdentityReference(alwaysAsId = true)
	private Vehicle vehicle;
	
	private List<Stop> stops;
	
	private List<Position> path;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	public List<Position> getPath() {
		return path;
	}

	public void setPath(List<Position> path) {
		this.path = path;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return stops.size() >= 2;
	}
	
	@JsonIgnore
	public Stop getOrigin() {
		return stops.get(0);
	}
	
	@JsonIgnore
	public Stop getDestination() {
		return stops.get(stops.size() - 1);
	}
	
	@JsonIgnore
	public List<Stop> getInnerPath() {
		List<Stop> innerPath = new ArrayList<>();
		
		for(Stop stop: stops.subList(1, stops.size() - 1))
			innerPath.add(stop);
		
		return innerPath;
	}
	
	@JsonIgnore
	public Stop getNearStop(Position p) {
		if(stops.size() > 0) {
			Stop near = stops.get(0);
			for(Stop s: stops) {
				if(s.getPosition().getDistanceTo(p) < near.getPosition().getDistanceTo(p)) {
					near = s;
				}
				
			}
			return near;
		}
		return null;
	}
	
	@JsonIgnore
	public double getRouteDistance(Position p) {
		return p.getDistanceTo(path);
	}
	
}
