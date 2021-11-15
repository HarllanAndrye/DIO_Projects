package com.harllan.dio.citiesapi.cities.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;

import com.harllan.dio.citiesapi.cities.entities.City;
import com.harllan.dio.citiesapi.cities.enums.UnitEnum;
import com.harllan.dio.citiesapi.cities.repositories.CityRepository;

@SpringBootTest
public class DistanceServiceTest {

	@Autowired
	private DistanceService service;

	@MockBean
	private CityRepository cityRepository;

	private City saoCarlos;
	private City ibate;

	@BeforeEach
	public void setUp() {
		ibate = new City(4929L, "Ibaté", 26, 3519303, "(-21.95840072631836,-47.98820114135742)",
				new Point(-21.95840072631836, -47.98820114135742));
		saoCarlos = new City(5254L, "São Carlos", 26, 3548906, "(-22.01740074157715,-47.88600158691406)",
				new Point(-22.01740074157715, -47.88600158691406));
	}

	@Test
	public void shouldCalculateInMetersUsingMath() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

		Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.METERS);

		assertThat(distance).isEqualTo(12426.810463475855);
	}

	@Test
	public void shouldCalculateInKilometersUsingMath() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

		Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.KILOMETERS);

		assertThat(distance).isCloseTo(12.426, offset(0.001d));
	}

	@Test
	public void shouldCalculateInMilesUsingMath() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

		Double distance = service.distanceUsingMath(4929L, 5254L, EarthRadius.MILES);

		assertThat(distance).isCloseTo(7.71, offset(0.01d));
	}

	@Test
	public void shouldCalculateInMetersUsingPoints() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));

		Double distance = service.distanceUsingPoints(4929L, 5254L, EarthRadius.METERS);

		assertThat(distance).isEqualTo(12426.810463475855);
	}
	
	@Test
	public void shouldCalculateDistanceByPointsInKm() {
		given(cityRepository.distanceByPoints(any(), any())).willReturn(1.0);
		
		Double distanceInKm = service.distanceByPointsInMiles(4929L, 5254L, UnitEnum.KILOMETER);
		
		assertEquals(1.609, distanceInKm);
	}
	
	@Test
	public void shouldCalculateDistanceByPointsInMeters() {
		given(cityRepository.distanceByPoints(any(), any())).willReturn(1.0);
		
		Double distanceInMeters = service.distanceByPointsInMiles(4929L, 5254L, UnitEnum.METER);
		
		assertEquals(1609, distanceInMeters);
	}
	
	@Test
	public void shouldCalculateDistanceByPointsInMiles() {
		given(cityRepository.distanceByPoints(any(), any())).willReturn(1.0);
		
		Double distanceInMiles = service.distanceByPointsInMiles(4929L, 5254L, null);
		
		assertEquals(1, distanceInMiles);
	}
	
	@Test
	public void shouldCalculateDistanceByCubeInMeters() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
		given(cityRepository.distanceByCube(any(), any(), any(), any())).willReturn(1.0);
		
		Double distanceInMeters = service.distanceByCubeInMeters(4929L, 5254L, null);
		
		assertEquals(1, distanceInMeters);
	}
	
	@Test
	public void shouldCalculateDistanceByCubeInMiles() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
		given(cityRepository.distanceByCube(any(), any(), any(), any())).willReturn(1000d);
		
		Double distanceInMiles = service.distanceByCubeInMeters(4929L, 5254L, UnitEnum.MILE);
		
		assertEquals("0,6214", String.format("%.4f", distanceInMiles));
	}
	
	@Test
	public void shouldCalculateDistanceByCubeInKm() {
		given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
		given(cityRepository.distanceByCube(any(), any(), any(), any())).willReturn(1.0);
		
		Double distanceInKm = service.distanceByCubeInMeters(4929L, 5254L, UnitEnum.KILOMETER);
		
		assertEquals(0.001, distanceInKm);
	}

}
