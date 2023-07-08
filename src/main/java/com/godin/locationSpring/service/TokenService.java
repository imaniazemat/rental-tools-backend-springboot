package com.godin.locationSpring.service;

import com.godin.locationSpring.model.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    Integer checkToken(String token);
}
