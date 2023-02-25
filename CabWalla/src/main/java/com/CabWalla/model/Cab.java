package com.CabWalla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Cab {
	
	private Integer cabId;
	private String carType;
	private Float perKmRate;
	
}