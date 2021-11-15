package com.harllan.dio.citiesapi.utils;

public class ConvertUnitUtils {
	
	private static final double MILES_KM = 1.609; //One mile to Km
	private static final double KM_MILES = 0.6214; //One Km to Mile
	private static final double KM_METER = 1000; //One Km to Meter
	private static final double METER_KM = 0.001; //One Meter to Km
	
	public static double convertMilesToKilometers(double miles) {
		return MILES_KM * miles;
	}
	
	public static double convertMilesToMeters(double miles) {
		double toKm = convertMilesToKilometers(miles);
		return convertKilometersToMeters(toKm);
	}
	
	public static double convertKilometersToMiles(double kilometers) {
		return KM_MILES * kilometers;
	}
	
	public static double convertKilometersToMeters(double kilometers) {
		return KM_METER * kilometers;
	}
	
	public static double convertMetersToKilometers(double meters) {
		return METER_KM * meters;
	}
	
	public static double convertMetersToMiles(double meters) {
		return meters / 1609.344;
	}

}
