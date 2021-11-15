package com.harllan.dio.citiesapi.utils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConvertUnitUtilsTest {
	
	@Test
	public void shouldConvertMilesToKilometers() {
		double toKm1 = ConvertUnitUtils.convertMilesToKilometers(1);
		double toKm2 = ConvertUnitUtils.convertMilesToKilometers(3.5);

		assertAll(() -> {
			assertEquals(1.609, toKm1);
			assertEquals(5.6315, toKm2);
		});
	}
	
	@Test
	public void shouldConvertMilesToMeters() {
		double toMeter1 = ConvertUnitUtils.convertMilesToMeters(1);
		double toMeter2 = ConvertUnitUtils.convertMilesToMeters(3.5);

		assertAll(() -> {
			assertEquals(1609, toMeter1);
			assertEquals(5631.5, toMeter2);
		});
	}
	
	@Test
	public void shouldConvertKilometersToMiles() {
		double toMiles1 = ConvertUnitUtils.convertKilometersToMiles(1);
		double toMiles2 = ConvertUnitUtils.convertKilometersToMiles(5.6315);

		assertAll(() -> {
			assertEquals(0.6214, toMiles1);
			assertEquals(3.5, Math.round(toMiles2*10.0)/10.0);
		});
	}
	
	@Test
	public void shouldConvertKilometersToMeters() {
		double toMeter1 = ConvertUnitUtils.convertKilometersToMeters(1);
		double toMeter2 = ConvertUnitUtils.convertKilometersToMeters(3.5);

		assertAll(() -> {
			assertEquals(1000, toMeter1);
			assertEquals(3500, toMeter2);
		});
	}
	
	@Test
	public void shouldConvertMetersToKilometers() {
		double toKm1 = ConvertUnitUtils.convertMetersToKilometers(1);
		double toKm2 = ConvertUnitUtils.convertMetersToKilometers(15250);

		assertAll(() -> {
			assertEquals(0.001, toKm1);
			assertEquals(15.250, toKm2);
		});
	}
	
	@Test
	public void shouldConvertMetersToMiles() {
		double toMiles1 = ConvertUnitUtils.convertMetersToMiles(1000);
		double toMiles2 = ConvertUnitUtils.convertMetersToMiles(3500);

		assertAll(() -> {
			assertEquals("0,6214", String.format("%.4f", toMiles1));
			assertEquals("2,175", String.format("%.3f", toMiles2));
		});
	}

}
