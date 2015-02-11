package com.monkeylittle.jpa.inheritance.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.monkeylittle.jpa.inheritance.model.Bike;

public interface BikeRepository extends PagingAndSortingRepository<Bike, Long> {

}
