package com.godin.locationSpring.service.impl;

import com.godin.locationSpring.model.Administrateur;
import com.godin.locationSpring.repository.AdministrateurRepository;
import com.godin.locationSpring.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    @Override
    public Boolean existsById(Integer id) {
        return administrateurRepository.existsById(id);
    }
}
