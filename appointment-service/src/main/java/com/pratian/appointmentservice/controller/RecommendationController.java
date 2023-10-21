package com.pratian.appointmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.appointmentservice.entities.Recommendation;
import com.pratian.appointmentservice.exceptions.DoctorNameNotFoundException;
import com.pratian.appointmentservice.service.RecommendationService;


@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
//@RequestMapping("/recommendation")
public class RecommendationController {
	
	@Autowired
	RecommendationService recommendationService;
	
	
	@PostMapping("/recommendations")
	public ResponseEntity<?> addRecommendation(@RequestBody Recommendation rec)throws DoctorNameNotFoundException {
		ResponseEntity<?> response = null;
       response = new ResponseEntity<Recommendation>(recommendationService.addRecommendation(rec), HttpStatus.OK);
    		   return response;
	}

	@GetMapping("/recommendations")
	public ResponseEntity<?> getAllRecommendation()throws DoctorNameNotFoundException {
		ResponseEntity<?> response = null;


			response = new ResponseEntity<>(recommendationService.getAllRecommendation(), HttpStatus.OK);
			return response;
	}

	
	@GetMapping("/recommendations/doctors")
	public ResponseEntity<?> getAllDoctorDetails()throws DoctorNameNotFoundException
	{
		ResponseEntity<?> response = null;
       response = new ResponseEntity<>(recommendationService.getAllDoctors(), HttpStatus.OK);
        return response;
	}

	@DeleteMapping("/recommendations/{id}")
	public ResponseEntity<?> deleteRecommendations(@PathVariable(name = "id") long id)
			throws DoctorNameNotFoundException {
		ResponseEntity<?> response = null;
//		try {
			recommendationService.removeRecommendation(id);
			response = new ResponseEntity<>(HttpStatus.OK);
//		} catch (DoctorNameNotFoundException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
		return response;
	}

}


	


