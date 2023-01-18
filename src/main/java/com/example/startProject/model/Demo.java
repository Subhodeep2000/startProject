package com.example.startProject.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Component
@Data
public class Demo implements Serializable {
	
	private int id;
	private String name;
	private String phone;
	
}
