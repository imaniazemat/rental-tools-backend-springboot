package com.godin.locationSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.CategoriePeriode;
import com.godin.locationSpring.repository.CategoriePeriodeRepository;

@Service
public class CategoriePeriodeService {
	@Autowired
	CategoriePeriodeRepository categoriePeriodeRepository;
	
	public List<CategoriePeriode> getAll(){
		return categoriePeriodeRepository.findAll();
	}
}
