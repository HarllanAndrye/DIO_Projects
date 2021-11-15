package com.harllan.dio.citiesapi.cities.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.citiesapi.cities.enums.UnitEnum;
import com.harllan.dio.citiesapi.cities.resources.docs.DistanceResourceDoc;
import com.harllan.dio.citiesapi.cities.service.DistanceService;
import com.harllan.dio.citiesapi.cities.service.EarthRadius;
import com.harllan.dio.citiesapi.cities.service.UnitConverter;

@RestController
@RequestMapping("/distances")
public class DistanceResource implements DistanceResourceDoc {

	private final DistanceService service;
	Logger log = LoggerFactory.getLogger(DistanceResource.class);

	public DistanceResource(DistanceService service) {
		this.service = service;
	}

	@GetMapping("/by-points")
	public Double byPoints(
			@RequestParam(name = "from") final Long city1Id, 
			@RequestParam(name = "to") final Long city2Id,
			@RequestParam(required = false) UnitEnum unit) {
		log.info("byPoints");
		return service.distanceByPointsInMiles(city1Id, city2Id, unit);
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(UnitEnum.class, new UnitConverter());
	}

	@GetMapping("/by-cube")
	public Double byCube(
			@RequestParam(name = "from") final Long city1Id,
			@RequestParam(name = "to") final Long city2Id,
			@RequestParam(required = false) UnitEnum unit) {
		log.info("byCube");
		return service.distanceByCubeInMeters(city1Id, city2Id, unit);
	}

	@GetMapping("/by-math")
	public Double byMath(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2,
			@RequestParam final EarthRadius unit) {
		log.info("byMath");
		return service.distanceUsingMath(city1, city2, unit);
	}

}
