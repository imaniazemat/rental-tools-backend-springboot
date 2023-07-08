package com.godin.locationSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.godin.locationSpring.model.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {
}
