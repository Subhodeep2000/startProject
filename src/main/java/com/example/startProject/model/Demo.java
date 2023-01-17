package com.example.startProject.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Component
@Data
public class Demo {
	
	private int id;
	private String name;
	private int phone;
	
}
