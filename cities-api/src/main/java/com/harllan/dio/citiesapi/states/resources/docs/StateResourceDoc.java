package com.harllan.dio.citiesapi.states.resources.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.harllan.dio.citiesapi.config.SwaggerConfig;
import com.harllan.dio.citiesapi.states.entities.State;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "States", tags = { SwaggerConfig.TAG_STATE })
public interface StateResourceDoc {
	
	@ApiOperation(value = "Return list of states")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of states.") })
	public List<State> states();
	
	@ApiOperation(value = "Return a state (or a list of states) search by name")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "State found"),
			@ApiResponse(code = 404, message = "State not found")
	})
	public ResponseEntity<List<State>> findByName(String name);

}
