package com.godin.locationSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.Categorie;
import com.godin.locationSpring.repository.CategorieRepository;

@Service
public class CategorieService {
	@Autowired
	CategorieRepository categorieRepository;
	
	public List<Categorie> getAll(){
		return categorieRepository.findAll();
	}
}
