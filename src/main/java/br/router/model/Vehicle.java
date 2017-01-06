package br.router.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {

	@Id
	private BigInteger id;

	public Vehicle() {
		
	}

	public String getId() {
		return id.toString();
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
}
