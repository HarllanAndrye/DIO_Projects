package com.harllan.dio.citiesapi.cities.resources.docs;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.harllan.dio.citiesapi.cities.entities.City;
import com.harllan.dio.citiesapi.config.SwaggerConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Cities", tags = { SwaggerConfig.TAG_CITY })
public interface CityResourceDoc {

	@ApiOperation(value = "Return list of cities with pagination.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of cities.") })
	public Page<City> cities(final Pageable page);
	
	@ApiOperation(value = "Return a city (or a list of cities) search by name")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "City found"),
			@ApiResponse(code = 404, message = "City not found")
	})
	public ResponseEntity<List<City>> findByName(String name);

}
