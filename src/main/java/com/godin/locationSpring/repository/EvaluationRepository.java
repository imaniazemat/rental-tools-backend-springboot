package com.godin.locationSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godin.locationSpring.model.Evaluation;
import com.godin.locationSpring.model.idClass.EvaluationId;

public interface EvaluationRepository extends JpaRepository<Evaluation, EvaluationId> {

}
