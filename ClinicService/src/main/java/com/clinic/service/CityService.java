package com.clinic.service;

import com.clinic.exception.StateNotFoundException;
import com.clinic.model.City;

public interface CityService {
			
	public City addCitytoState(String name,City city) throws StateNotFoundException;
	
	
}
