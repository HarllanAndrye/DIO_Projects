package com.harllan.dio.citiesapi.states.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.citiesapi.states.entities.State;
import com.harllan.dio.citiesapi.states.repositories.StateRepository;
import com.harllan.dio.citiesapi.states.resources.docs.StateResourceDoc;

@RestController
@RequestMapping("/states")
public class StateResource implements StateResourceDoc {

	private final StateRepository repository;

	public StateResource(final StateRepository repository) {
		this.repository = repository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<State> states() {
		return repository.findAll();
	}

	@GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> findByName(@RequestParam String name) {
		List<State> list = repository.findByNameContainingIgnoreCase(name);
		
		if (list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
