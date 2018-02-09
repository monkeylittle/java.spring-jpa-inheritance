package com.monkeylittle.jpa.inheritance.model;

import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle {

	public Bike(Colour colour) {

		super(colour, false);
	}

	public Bike() {

	}
}
