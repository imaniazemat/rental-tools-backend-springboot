package com.godin.locationSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godin.locationSpring.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

    public Utilisateur findUtilisateurByCourriel(String courriel);

    public Utilisateur findUtilisateurByCourrielAndPassword(String courriel, String password);


}
