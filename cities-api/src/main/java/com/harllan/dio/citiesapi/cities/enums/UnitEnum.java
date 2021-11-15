package com.harllan.dio.citiesapi.cities.enums;

import java.util.Arrays;

public enum UnitEnum {
	
	MILE("mile"), KILOMETER("kilometer"), METER("meter");
	
	private String value;
	
	private UnitEnum(String value) {
		this.value = value;
	}
	
	public static UnitEnum fromValue(String value) {
		for (UnitEnum unit : values()) {
			if (unit.value.equalsIgnoreCase(value)) {
				return unit;
			}
		}
		
		throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}

}
