package com.harllan.dio.citiesapi.cities.resources;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.citiesapi.cities.entities.City;
import com.harllan.dio.citiesapi.cities.repositories.CityRepository;
import com.harllan.dio.citiesapi.cities.resources.docs.CityResourceDoc;

@RestController
@RequestMapping("cities")
public class CityResource implements CityResourceDoc {

	private final CityRepository repository;

	public CityResource(final CityRepository repository) {
		this.repository = repository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Page<City> cities(final Pageable page) {
		return repository.findAll(page);
	}

	@GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<City>> findByName(@RequestParam String name) {
		List<City> list = repository.findByNameContainingIgnoreCase(name);
		
		if (list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
