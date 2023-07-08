package com.godin.locationSpring.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.Detail;
import com.godin.locationSpring.model.idClass.DetailId;
import com.godin.locationSpring.repository.DetailRepository;

@Service
public class DetailService {
	@Autowired
	DetailRepository detailRepository;
	
	public List<Detail> getAll(){
		return detailRepository.findAll();
	}
	
	
	public boolean insert(List<Map<String, Object>> listeDetail, int annonceId) {
		for(int i =0; i< listeDetail.size(); i++) {
			listeDetail.get(i);
			Detail detail = new Detail();
			detail.setCategoriePeriodeId((int)listeDetail.get(i).get("id"));
			detail.setPrix(Double.valueOf(listeDetail.get(i).get("prix").toString()));
			detail.setAnnonceId(annonceId);
			detailRepository.save(detail);	
		}
		return true;
	}
	
	public void deleteDetail(int annonceId, int categoriePeriodeId) {
//		Detail detail2 = detailRepository.findById(new DetailId(17, 3)).get();
		detailRepository.deleteById(new DetailId(annonceId , categoriePeriodeId));
//		detailRepository.delete(detail2);
		
	}
	
	public void deleteByAnnonceId(int annonceId) {
		detailRepository.findByAnnonceId(annonceId).forEach(x->{
			detailRepository.delete(x);
		});
	}
	
	public List<Detail> getDetail(int annonceId) {
		return detailRepository.findByAnnonceId(annonceId);
	}
	public void insert(Detail detail) {
		detailRepository.save(detail);
	}
	
}
