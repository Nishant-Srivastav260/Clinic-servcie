package com.pratian.appointmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Test;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.TestAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.TestNotFoundException;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.repository.TestRepo;
import com.pratian.appointmentservice.service.TestService;

@Transactional
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepo testRepo;
	
	@Autowired
	IAppointmentRepo appRepo;
	

	@Override
    public Test addTest(Test test) throws TestAlreadyPresentException{
		if(testRepo.existsById(test.getTestId())) {
		throw new TestAlreadyPresentException();
	}
	else {
		testRepo.save(test);
		return test;
	}}
	
	@Override
	public List<Test> getAllTest() {	
		return testRepo.findAll();
	}

	@Override
	public void removeTest(long testId) throws TestNotFoundException {
		if(testRepo.existsById(testId)) {
		testRepo.deleteById(testId);
		}
		else {
			throw new TestNotFoundException();
		}
	}

	@Override
	public Test getTestById(long testId) throws TestNotFoundException{
		if(testRepo.existsById(testId)) {
		return testRepo.getTestById(testId);
				}
		else throw new TestNotFoundException();
	}


	@Override
	public Test updateTest(Long id, Test test) throws TestNotFoundException {
		if(testRepo.existsById(id)) {
			testRepo.getTestById(id).setTestName(test.getTestName());
			return test;
		}
		else {
			throw new TestNotFoundException("Entered test id does not exist");
		}
		
	}

	@Override
	public Test getTestByName(String testName) throws TestNotFoundException{
		Test t= testRepo.getTestName(testName);
		if(t!=null) {
			return t;
		}
		else throw new TestNotFoundException();
	}

	@Override
	public Test addTestByAppointmentsId(long id, Test test) throws AppointmentNotFoundException {
		if(!appRepo.existsById(id)) {
			throw new AppointmentNotFoundException();
		}
		else {
			Appointment a=appRepo.getAppointmentById(id);
			testRepo.save(test);
			a.getTests().add(test);
			return test;
		}
		
	}

	@Override
	public Test updateTestForAppointment(long id, long testId, Test test) throws AppointmentNotFoundException {
		if(!appRepo.existsById(id)) {
			throw new AppointmentNotFoundException();   
		}
		else {
			Appointment a=appRepo.getAppointmentById(id);     
			//if(testRepo.existsById(testId)) {
			List<Test> list=new ArrayList<Test>();
			list=a.getTests();
				for(Test t: list) {
					if(t.getTestId()==testId) {
						a.getTests().remove(testRepo.getTestById(testId));
						break;
					}
					else continue;
		}
//				if(testRepo.existsById(test.getTestId()))
//					testRepo.save(testRepo.findById(test.getTestId()).get());
//				a.getTests().add(testRepo.findById(test.getTestId()).get());
//				return test;
//			}
//			else {
				testRepo.save(test);
				a.getTests().add(test);
				return test;
			//}
		}
	}

}
