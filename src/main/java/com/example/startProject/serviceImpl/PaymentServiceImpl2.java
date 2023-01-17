package com.example.startProject.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.startProject.service.PaymentService;
// I am currently at 37:55 time of lecture

@Service("P1")
@Primary
public class PaymentServiceImpl2 implements PaymentService {

	private Logger logger = LoggerFactory.getLogger(PaymentServiceImpl2.class);
	
	@Override
	public void printMessage() {
		logger.info("In PaymentServiceImpl2");
	}

}
