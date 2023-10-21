package com.clinic.service;

import com.clinic.exception.StateAlreadyExistException;
import com.clinic.model.State;

public interface StateService {
	
	public State addState(State state) throws StateAlreadyExistException;

}
