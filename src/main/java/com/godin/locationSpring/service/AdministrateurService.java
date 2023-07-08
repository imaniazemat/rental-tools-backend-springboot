package com.godin.locationSpring.service;

import com.godin.locationSpring.model.Administrateur;
import org.springframework.stereotype.Service;

@Service
public interface AdministrateurService {

    Boolean existsById(Integer id);
}
