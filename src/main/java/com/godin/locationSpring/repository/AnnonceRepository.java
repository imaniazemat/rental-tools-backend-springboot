package com.godin.locationSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godin.locationSpring.model.Annonce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
	List<Annonce> findByUtilisateurProprietaireId(int utilisateurProprietaireId);

	@Query(nativeQuery = true, value = "SELECT * FROM annonce WHERE annonce.titre LIKE %:word% AND annonce.status=1")
	List<Annonce> searchByWord(@Param("word") String word);

	@Query(nativeQuery = true, value = "SELECT * FROM annonce WHERE annonce.categorie_id=?1 AND annonce.status=1")
	List<Annonce> searchByCategorieId(int categorieId);
}
