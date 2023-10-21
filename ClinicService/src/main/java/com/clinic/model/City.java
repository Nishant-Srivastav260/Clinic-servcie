package com.clinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cityId;
	private String cityName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cityId")
	@JsonIgnore
	private List<Clinic> clinic=new ArrayList<>();

}
