package com.godin.locationSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.Membre;
import com.godin.locationSpring.repository.MembreRepository;

@Service
public class MembreService {
	@Autowired
	MembreRepository membreRepository;
	
	public Membre getOne() {
		return membreRepository.findAll().get(0);
	}
	
	public void save(Membre membre) {
		membreRepository.save(membre);
	}

}
