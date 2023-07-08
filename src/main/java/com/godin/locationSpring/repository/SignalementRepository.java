package com.godin.locationSpring.repository;

import com.godin.locationSpring.model.Signalement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalementRepository extends JpaRepository<Signalement, Integer> {

}
