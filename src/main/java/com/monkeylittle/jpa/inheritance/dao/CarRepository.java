package com.monkeylittle.jpa.inheritance.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.monkeylittle.jpa.inheritance.model.Car;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

}
