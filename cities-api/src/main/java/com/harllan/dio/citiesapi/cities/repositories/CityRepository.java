package com.harllan.dio.citiesapi.cities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harllan.dio.citiesapi.cities.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	List<City> findByNameLike(String name);
	
	List<City> findByNameContainingIgnoreCase(String name);

	@Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
	Double distanceByPoints(final Long cityId1, final Long cityId2);

	@Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
	Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

}
