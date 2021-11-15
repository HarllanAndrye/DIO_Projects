package com.harllan.dio.citiesapi.cities.service;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.harllan.dio.citiesapi.cities.entities.City;
import com.harllan.dio.citiesapi.cities.enums.UnitEnum;
import com.harllan.dio.citiesapi.cities.repositories.CityRepository;
import com.harllan.dio.citiesapi.utils.ConvertUnitUtils;
import com.harllan.dio.citiesapi.utils.StringLocationUtils;

@Service
public class DistanceService {

	private final CityRepository cityRepository;
	Logger log = LoggerFactory.getLogger(DistanceService.class);

	public DistanceService(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	/**
	 * 1st option
	 *
	 * @param city1
	 * @param city2
	 * @param unit
	 * @return
	 */
	public Double distanceUsingMath(final Long city1, final Long city2, final EarthRadius unit) {
		log.info("distanceUsingMath({}, {}, {})", city1, city2, unit);
		final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
		final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());

		return doCalculation(location1[0], location1[1], location2[0], location2[1], unit);
	}

	/**
	 * 2nd option
	 *
	 * @param city1
	 * @param city2
	 * @return
	 */
	public Double distanceByPointsInMiles(final Long city1Id, final Long city2Id, UnitEnum unit) {
		log.info("nativePostgresInMiles({}, {})", city1Id, city2Id);
		
		double distanceInMiles = cityRepository.distanceByPoints(city1Id, city2Id);
		
		if (unit != null) {
			if (UnitEnum.KILOMETER.equals(unit)) {
				return ConvertUnitUtils.convertMilesToKilometers(distanceInMiles);
			} else if (UnitEnum.METER.equals(unit)) {
				return ConvertUnitUtils.convertMilesToMeters(distanceInMiles);
			}
		}
		
		return distanceInMiles;
	}

	/**
	 * 3rd option
	 *
	 * @param city1
	 * @param city2
	 * @param unit
	 * @return
	 */
	public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius unit) {
		log.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
		final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		Point p1 = cities.get(0).getLocation();
		Point p2 = cities.get(1).getLocation();

		return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
	}

	/**
	 * 4th option
	 *
	 * @param city1
	 * @param city2
	 * @return
	 */
	public Double distanceByCubeInMeters(Long city1Id, Long city2Id, UnitEnum unit) {
		log.info("distanceByCubeInMeters({}, {})", city1Id, city2Id);
		final List<City> cities = cityRepository.findAllById((Arrays.asList(city1Id, city2Id)));

		Point p1 = cities.get(0).getLocation();
		Point p2 = cities.get(1).getLocation();

		double distanceInMeters = cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		
		if (unit != null) {
			if (UnitEnum.KILOMETER.equals(unit)) {
				return ConvertUnitUtils.convertMetersToKilometers(distanceInMeters);
			} else if (UnitEnum.MILE.equals(unit)) {
				return ConvertUnitUtils.convertMetersToMiles(distanceInMeters);
			}
		}
		
		return distanceInMeters;
	}

	private double doCalculation(final double lat1, final double lon1, final double lat2, final double lng2,
			final EarthRadius earthRadius) {
		double lat = toRadians(lat2 - lat1);
		double lon = toRadians(lng2 - lon1);
		double a = sin(lat / 2) * sin(lat / 2)
				+ cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
		double c = 2 * atan2(sqrt(a), sqrt(1 - a));

		return earthRadius.getValue() * c;
	}

}
