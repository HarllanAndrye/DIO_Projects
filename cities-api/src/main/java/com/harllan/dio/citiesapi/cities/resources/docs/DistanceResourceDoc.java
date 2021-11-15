package com.harllan.dio.citiesapi.cities.resources.docs;

import com.harllan.dio.citiesapi.cities.enums.UnitEnum;
import com.harllan.dio.citiesapi.cities.service.EarthRadius;
import com.harllan.dio.citiesapi.config.SwaggerConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Cities", tags = { SwaggerConfig.TAG_CITY })
public interface DistanceResourceDoc {
	
	@ApiOperation(value = "Return distance (default: in miles) by points")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Distance of cities.") })
	public Double byPoints(final Long city1Id, final Long city2Id, UnitEnum unit);

	@ApiOperation(value = "Return distance (default: in meters) by cube")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Distance of cities.") })
	public Double byCube(final Long city1Id, final Long city2Id, UnitEnum unit);

	@ApiOperation(value = "Return distance by math")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Distance of cities.") })
	public Double byMath(final Long city1, final Long city2, final EarthRadius unit);

}
