package com.harllan.dio.citiesapi.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harllan.dio.citiesapi.countries.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	List<Country> findByNameContainingIgnoreCase(String name);

}
