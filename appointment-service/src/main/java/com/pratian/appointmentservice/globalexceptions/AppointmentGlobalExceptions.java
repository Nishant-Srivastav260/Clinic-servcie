package com.pratian.appointmentservice.globalexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.DoctorNameNotFoundException;
import com.pratian.appointmentservice.exceptions.FeedbackNotFoundException;
import com.pratian.appointmentservice.exceptions.PrescriptionServiceException;
import com.pratian.appointmentservice.exceptions.TestAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.TestNotFoundException;
import com.pratian.appointmentservice.exceptions.VitalAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.VitalsNotFoundException;

@ControllerAdvice
public class AppointmentGlobalExceptions { // Global Exception Class

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<String> handleAppointmentNotFoundException(AppointmentNotFoundException appointmentNotFound) {

		return new ResponseEntity<String>("Appointment not found, Please enter correct field", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TestNotFoundException.class)
	public ResponseEntity<String> handleTestNotFoundException(TestNotFoundException testtNotFound) {

		return new ResponseEntity<String>("Test not found, Please enter correct field", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TestAlreadyPresentException.class)
	public ResponseEntity<String> handleTestAlreadyPresentException(TestAlreadyPresentException testAlreadyPresent) {

		return new ResponseEntity<String>("Test already present for this id, Please enter correct field",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VitalsNotFoundException.class)
	public ResponseEntity<String> handleVitalsNotFoundException(VitalsNotFoundException vitalsNotFound) {

		return new ResponseEntity<String>("Vitals not found, Please enter correct field", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VitalAlreadyPresentException.class)
	public ResponseEntity<String> handleVitalAlreadyPresentException(
			VitalAlreadyPresentException vitalsAlreadyPresent) {

		return new ResponseEntity<String>("Vitals already present for id, Please enter correct field",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DoctorNameNotFoundException.class)
	public ResponseEntity<String> handleDoctorNameNotFoundException(DoctorNameNotFoundException doctorsNotFound) {

		return new ResponseEntity<String>("Doctor details not found, Please enter correct field",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<String> handleFeedbackNotFoundException(FeedbackNotFoundException feedbackNotFound) {

		return new ResponseEntity<String>("Feedback not found, Please enter correct field", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PrescriptionServiceException.class)
	public ResponseEntity<String> handlePrescriptionServiceException(
			PrescriptionServiceException prescriptionNotFound) {

		return new ResponseEntity<String>("Prescription List is Empty, Please enter correct field", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {

		return new ResponseEntity<String>("Make sure to enter the right information, Please enter correct field",
				HttpStatus.BAD_REQUEST);
	}

}
