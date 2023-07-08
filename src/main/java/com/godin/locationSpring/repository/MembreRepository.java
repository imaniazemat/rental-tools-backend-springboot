package com.godin.locationSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godin.locationSpring.model.Membre;

public interface MembreRepository extends JpaRepository<Membre, Integer> {

}
