package com.godin.locationSpring.service;


import com.godin.locationSpring.model.Signalement;
import com.godin.locationSpring.repository.SignalementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalementService {

    @Autowired
    private SignalementRepository signalementRepository;

    public void createSignalement(Signalement signalement) {
        signalementRepository.save(signalement);
    }

    public List<Signalement> getAllSignalements() {
        return signalementRepository.findAll();
    }
}
