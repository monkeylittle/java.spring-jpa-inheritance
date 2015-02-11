package com.monkeylittle.jpa.inheritance.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.monkeylittle.jpa.inheritance.model.Airplane;

public interface AirplaneRepository extends PagingAndSortingRepository<Airplane, Long> {

}
