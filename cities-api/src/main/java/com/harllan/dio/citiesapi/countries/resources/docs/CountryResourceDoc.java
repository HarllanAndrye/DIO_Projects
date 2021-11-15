package com.harllan.dio.citiesapi.countries.resources.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.harllan.dio.citiesapi.config.SwaggerConfig;
import com.harllan.dio.citiesapi.countries.entities.Country;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Countries", tags = { SwaggerConfig.TAG_COUNTRY })
public interface CountryResourceDoc {
	
	@ApiOperation(value = "Return list of countries")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of countries.") })
	public List<Country> countries();
	
	@ApiOperation(value = "Return a country (or a list of countries) search by name")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Country found"),
			@ApiResponse(code = 404, message = "Country not found")
	})
	public ResponseEntity<List<Country>> findByName(String name);

}
