package com.example.startProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.startProject.model.Demo;
import com.example.startProject.service.PaymentService;

@RestController
@RequestMapping("/v1")
public class DemoController {
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
//	@Autowired
//	@Qualifier("PaymentServiceImpl2")
//	PaymentService paymentService2;
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/demo")
	public Demo getDemo() {
		Demo demo = new Demo();
		logger.info("Demo object is : {}",demo);
		paymentService.printMessage();
		return demo;
	}
	
	@PostMapping("/demo")
	public Demo saveDemo() {
		Demo demo = new Demo();
		logger.info("Demo object is : {}",demo);
		paymentService.printMessage();
		return demo;
	}
	
//	@RequestMapping("/demo",method=RequestMapping.GET)
//	public void getDemo1() {
//		
//	}
	
	@GetMapping("/requestParam")
	public void requestParamMethod(@RequestParam(required=false) String name) {
		logger.info("Request Param Received with : {}",name);
	}
	
	@GetMapping("/pathVariable/{id}/addr/{addrId}")
	public void requestParamMethod(@PathVariable int id,@PathVariable int addrId) {
		logger.info("Path Variable Received with : {}",id);
	}
	
	@PostMapping("/requestBody")
	public void requestParamMethod(@RequestBody Demo demoObj) {
		logger.info("Request Param Received with : {}",demoObj.getName());
	}
	
}