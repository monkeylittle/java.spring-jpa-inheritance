package com.monkeylittle.jpa.inheritance.model;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

	public Car(Colour colour) {
		
		super(colour);
	}
	
	public Car() {
		
	}
}
