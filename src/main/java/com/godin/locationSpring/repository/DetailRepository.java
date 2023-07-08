package com.godin.locationSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godin.locationSpring.model.Detail;
import com.godin.locationSpring.model.idClass.DetailId;

public interface DetailRepository extends JpaRepository<Detail, DetailId> {
	List<Detail> findByAnnonceId(int AnnonceId);
}
