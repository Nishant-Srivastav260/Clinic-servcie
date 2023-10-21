package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.Test;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.TestAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.TestNotFoundException;

public interface TestService {
	public Test addTest(Test test) throws TestAlreadyPresentException;
	public Test getTestByName(String testName) throws TestNotFoundException;
	public Test getTestById(long testId) throws TestNotFoundException;
	public List<Test> getAllTest();
	public void removeTest(long testId) throws TestNotFoundException  ;
	public Test updateTest(Long id, Test test) throws TestNotFoundException;
	
	public Test addTestByAppointmentsId(long id, Test test) throws AppointmentNotFoundException;
	public Test updateTestForAppointment(long id, long testId, Test test) throws AppointmentNotFoundException;
}
