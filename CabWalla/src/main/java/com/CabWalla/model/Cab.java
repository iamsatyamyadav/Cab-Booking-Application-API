package com.CabWalla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Cab {
	
	private Integer cabId;
	private String carType;
	private Float perKmRate;
	
}