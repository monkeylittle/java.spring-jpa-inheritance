package com.monkeylittle.jpa.inheritance.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.IteratorUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.monkeylittle.jpa.inheritance.Application;
import com.monkeylittle.jpa.inheritance.model.Airplane;
import com.monkeylittle.jpa.inheritance.model.Bike;
import com.monkeylittle.jpa.inheritance.model.Car;
import com.monkeylittle.jpa.inheritance.model.Colour;
import com.monkeylittle.jpa.inheritance.model.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class CarRepositoryTest {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Before
	public void before() {
		
		vehicleRepository.save(new Bike(Colour.BLACK));
		vehicleRepository.save(new Car(Colour.WHITE));
		vehicleRepository.save(new Airplane(Colour.BLACK));
	}
	
	@Test
	public void find_all() {
		
		List<Car> cars = IteratorUtils.toList(carRepository.findAll().iterator());
		
		assertThat(cars.size(), equalTo(1));
		assertCar(cars.get(0), Colour.WHITE);
	}
	
	private void assertVehicle(Vehicle vehicle, Colour colour) {
		
		assertThat(vehicle.getId(), is(notNullValue()));
		assertThat(vehicle.getColour(), is(colour));
	}
	
	private void assertCar(Car car, Colour colour) {
		
		assertVehicle(car, colour);
	}
}
