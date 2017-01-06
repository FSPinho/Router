package br.router.model;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.router.util.math.GeoMath;

public class Position {
	
	@Id
	private BigInteger id;

	private Double latitude = null;
	private Double longitude = null;
		
	public Position() {
		
	}

	public Position(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@JsonIgnore
	public Double getDistanceTo(Position another) {
		return GeoMath.haversine(latitude, longitude, another.getLatitude(), another.getLongitude());
	}
	
	@JsonIgnore
	public Double getDistanceTo(Position a, Position b) {
		return GeoMath.distanceToLine(latitude, longitude, a.getLatitude(), a.getLongitude(), b.getLatitude(), b.getLongitude());
	}
	
	@JsonIgnore
	public Double getDistanceTo(List<Position> path) {
		if(path.size() > 0) {
			Double min = getDistanceTo(path.get(0));
			
			for(Position p: path) {
				Double d = getDistanceTo(p);
				if(min > d) min = d;
			}
			
			return min;
		}
		return null;
	}
	
	@JsonIgnore
	public Position getNear(List<Position> path) {
		if(path.size() > 0) {
			Position near = path.get(0);
			Double min = getDistanceTo(near);
			
			for(Position p: path) {
				Double d = getDistanceTo(p);
				if(min > d) {
					near = p;
					min = d;
				}
			}
			
			return near;
		}
		return null;
	}
	
}
