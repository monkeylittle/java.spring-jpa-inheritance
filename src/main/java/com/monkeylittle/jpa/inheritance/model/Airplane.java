package com.monkeylittle.jpa.inheritance.model;

import javax.persistence.Entity;

@Entity
public class Airplane extends Vehicle {

	public Airplane(Colour colour) {
		
		super(colour);
	}
	
	public Airplane() {
		
	}
}
