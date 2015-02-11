package com.monkeylittle.jpa.inheritance.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.monkeylittle.jpa.inheritance.model.Colour;
import com.monkeylittle.jpa.inheritance.model.Vehicle;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {

	List<Vehicle> findByColour(Colour colour);
}
