package com.godin.locationSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godin.locationSpring.model.Membre;
import com.godin.locationSpring.service.MembreService;

@RestController
public class MembreController {

	@Autowired
	MembreService membreService;
	
	@GetMapping("/membre")
	public Membre getOne() {
		return membreService.getOne();
	}
	
}
