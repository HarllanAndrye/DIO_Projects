package com.harllan.dio.citiesapi.countries.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.citiesapi.countries.entities.Country;
import com.harllan.dio.citiesapi.countries.repositories.CountryRepository;
import com.harllan.dio.citiesapi.countries.resources.docs.CountryResourceDoc;

@RestController
@RequestMapping("countries")
public class CountryResource implements CountryResourceDoc {

	private final CountryRepository repository;

	public CountryResource(final CountryRepository repository) {
		this.repository = repository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Country> countries() {
		return repository.findAll();
	}

	@GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> findByName(@RequestParam String name) {
		List<Country> list = repository.findByNameContainingIgnoreCase(name);
		
		if (list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
