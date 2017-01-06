package br.router.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

public class Stop {
	
	@Id
	private BigInteger id;
	
	private String name;
	
	private Position position;

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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
		
}
