package com.godin.locationSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.EtatOutil;
import com.godin.locationSpring.repository.EtatOutilRepository;

@Service
public class EtatOutilService {
	@Autowired
	EtatOutilRepository etatOutilRepository;
	
	public List<EtatOutil> getAll(){
		return etatOutilRepository.findAll();
	}
}
