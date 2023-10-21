package com.clinic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesRequest {

	private long serviceId;
	private String serviceName;
	private String serviceCode;
	private String serviceDesc;
	private double avgPrice;
	private boolean active;
}
