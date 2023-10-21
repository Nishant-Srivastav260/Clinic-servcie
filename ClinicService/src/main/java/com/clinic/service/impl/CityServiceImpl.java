package com.clinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.StateNotFoundException;
import com.clinic.model.City;
import com.clinic.model.State;
import com.clinic.repository.CityRepository;
import com.clinic.repository.StateRepository;
import com.clinic.service.CityService;


@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	StateRepository stateRepo;
	
	
	@Autowired
	CityRepository cityRepo;
	
	
	@Override
	public City addCitytoState(String name, City city) throws StateNotFoundException {
		State state=stateRepo.getStateObj(name);
		if(state!=null) {
			City cit=new City();
			List<City> c=state.getCity();
			cit.setCityName(city.getCityName());
			c.add(cit);
			cityRepo.save(cit);
			return cit;
		}else {
			throw new StateNotFoundException();
		}
	}

}
