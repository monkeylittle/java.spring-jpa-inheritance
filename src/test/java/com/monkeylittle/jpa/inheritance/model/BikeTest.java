package com.monkeylittle.jpa.inheritance.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.monkeylittle.jpa.inheritance.model.Airplane;
import com.monkeylittle.jpa.inheritance.model.Colour;

public class BikeTest {

	@Test
	public void isMotorised() {

		assertThat(new Bike(Colour.BLACK).isMotorised(), is(false));
	}
}
