package com.harllan.dio.citiesapi.cities.service;

import java.beans.PropertyEditorSupport;

import com.harllan.dio.citiesapi.cities.enums.UnitEnum;

public class UnitConverter extends PropertyEditorSupport {
	
	public void setAsText(final String text) throws IllegalArgumentException {
        setValue(UnitEnum.fromValue(text));
    }

}
