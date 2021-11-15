package com.harllan.dio.citiesapi.states.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harllan.dio.citiesapi.states.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

	List<State> findByNameContainingIgnoreCase(String name);

}
