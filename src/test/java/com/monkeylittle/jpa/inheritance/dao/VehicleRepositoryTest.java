package com.monkeylittle.jpa.inheritance.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.stream.Collectors;

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
public class VehicleRepositoryTest {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Before
	public void before() {
		
		vehicleRepository.save(new Bike(Colour.BLACK));
		vehicleRepository.save(new Car(Colour.WHITE));
		vehicleRepository.save(new Airplane(Colour.BLACK));
	}
	
	@Test
	public void find_all() {
		
		List<Vehicle> vehicles = IteratorUtils.toList(vehicleRepository.findAll().iterator());
		
		assertThat(vehicles.size(), equalTo(3));
		
		List<Bike> bikes = vehicles.stream()
				.filter(v -> v.getClass().isAssignableFrom(Bike.class))
				.map(v -> (Bike) v)
				.collect(Collectors.toList());
		
		assertThat(bikes.size(), equalTo(1));
		assertBike(bikes.get(0), Colour.BLACK);
		
		List<Car> cars = vehicles.stream()
				.filter(v -> v.getClass().isAssignableFrom(Car.class))
				.map(v -> (Car) v)
				.collect(Collectors.toList());
		
		assertThat(cars.size(), equalTo(1));
		assertCar(cars.get(0), Colour.WHITE);
		
		List<Airplane> airplanes = vehicles.stream()
				.filter(v -> v.getClass().isAssignableFrom(Airplane.class))
				.map(v -> (Airplane) v)
				.collect(Collectors.toList());
		
		assertThat(airplanes.size(), equalTo(1));
		assertAirplane(airplanes.get(0), Colour.BLACK);
	}
	
	@Test
	public void find_all_black() {
		
		List<Vehicle> vehicles = vehicleRepository.findByColour(Colour.BLACK);
		
		assertThat(vehicles.size(), equalTo(2));
	}
	
	private void assertVehicle(Vehicle vehicle, Colour colour) {
		
		assertThat(vehicle.getId(), is(notNullValue()));
		assertThat(vehicle.getColour(), is(colour));
	}
	
	private void assertAirplane(Airplane airplane, Colour colour) {
		
		assertVehicle(airplane, colour);
	}
	
	private void assertBike(Bike bike, Colour colour) {
		
		assertVehicle(bike, colour);
	}
	
	private void assertCar(Car car, Colour colour) {
		
		assertVehicle(car, colour);
	}
}
