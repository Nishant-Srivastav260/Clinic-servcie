package com.pratian.appointmentservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratian.appointmentservice.controller.RecommendationController;
import com.pratian.appointmentservice.entities.Recommendation;
import com.pratian.appointmentservice.service.RecommendationService;
import com.pratian.appointmentservice.service.impl.AppointmentServiceImpl;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = { RecommendationController.class })
public class RecommendationControllerTest {

	@MockBean
	RecommendationService recommendationService;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	AppointmentServiceImpl impl;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void addRecommendation() throws Exception {

		Recommendation recommendation = new Recommendation();

		recommendation.setRecommendationId(1);

		String json = mapper.writeValueAsString(recommendation);

		when(recommendationService.addRecommendation(Mockito.any())).thenReturn(recommendation);
		mockMvc.perform(post("/recommendations").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
				.andExpect(jsonPath("$.recommendationId", Matchers.equalTo(1)));

	}

	@Test
	public void getAllRecommendation() throws Exception {

		List<Recommendation> list = new ArrayList<>();
		Recommendation recommendation1 = new Recommendation();

		recommendation1.setRecommendationId(1);

		Recommendation recommendation2 = new Recommendation();

		recommendation2.setRecommendationId(2);

		list.add(recommendation1);
		list.add(recommendation2);

		when(recommendationService.getAllRecommendation()).thenReturn(list);
		mockMvc.perform(get("/recommendations").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].recommendationId", Matchers.equalTo(1)));

	}

//	@Test
//	public void deleteRecommendations() throws Exception {
//
//		// List<Recommendation> list= new ArrayList<>();
//		Recommendation recommendation1 = new Recommendation();
//
//		recommendation1.setRecommendationId(1);
//
//		Recommendation recommendation2 = new Recommendation();
//
//		recommendation2.setRecommendationId(2);
//
//
//	}
}



