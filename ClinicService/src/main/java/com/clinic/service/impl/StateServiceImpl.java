package com.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.StateAlreadyExistException;
import com.clinic.model.State;
import com.clinic.repository.StateRepository;
import com.clinic.service.StateService;


@Service
public class StateServiceImpl implements StateService{

	@Autowired
	StateRepository stateRepo;
	
	@Override
	public State addState(State state) throws StateAlreadyExistException {
		State s=new State();
		if(stateRepo.existsById(state.getStateId())) {
			throw new StateAlreadyExistException();
		}else {
			s.setName(state.getName());			
			return stateRepo.save(s);
		}
	}
	
	
}
