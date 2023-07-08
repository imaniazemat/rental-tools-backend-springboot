package com.godin.locationSpring.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.Evaluation;
import com.godin.locationSpring.model.idClass.EvaluationId;
import com.godin.locationSpring.repository.EvaluationRepository;

@Service
public class EvaluationService {
	
	@Autowired
	EvaluationRepository evaluationRepository;
	
	public Evaluation getEvaluation(int annonceId, int membreId) {
		return evaluationRepository.findById(new EvaluationId(annonceId, membreId)).get();
	}
	
	public List<Evaluation> getAll(){
		return evaluationRepository.findAll();
	}
	
	public List<Evaluation> getByAnnonceId(int annonceId){
		 List<Evaluation> l = getAll();
		 l.removeIf(x->(x.getAnnonceId()!=annonceId));
		 return l;
	}
	
	public void insert(Map<String, Object> body) {
		Evaluation evaluation = new Evaluation();
		evaluation.setAnnonceId((Integer)body.get("annonceId"));
		evaluation.setMembreId((Integer)body.get("membreId"));
		evaluation.setCommentaire((String)body.get("commentaire"));
		evaluation.setNote((Integer)body.get("note"));
		evaluation.setDateEvaluation(new Timestamp(System.currentTimeMillis()));
		evaluationRepository.save(evaluation);
	}
}
