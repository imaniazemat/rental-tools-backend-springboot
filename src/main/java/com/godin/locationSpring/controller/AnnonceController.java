package com.godin.locationSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.godin.locationSpring.model.Annonce;
import com.godin.locationSpring.service.AnnonceService;
import com.godin.locationSpring.service.DetailService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AnnonceController {
	
	@Autowired
	AnnonceService annonceService;
	
	@Autowired
	DetailService detailService;
	
	@GetMapping("/annonces")	
	public Annonce getAnnonces(){
		return annonceService.getOneAnnonce();
	}
	
	@GetMapping("/annonce/{id}")
	public Annonce getAnnonce(@PathVariable String id) {
		return annonceService.getAnnonce(Integer.parseInt(id));
	}
	
	@PostMapping("annonce/insert")
	@Transactional
	public String insertAnnonce(@RequestBody Map<String, Object> body) {
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> listeDetail= (List<Map<String, Object>>)body.get("listeDetail");
			@SuppressWarnings("unchecked")
			Map<String, Object> annonceMap = (Map<String, Object>)body.get("annonce");
			int annonceId = annonceService.insert(annonceMap);
			detailService.insert(listeDetail, annonceId);
			
			return "ENREGISTRÉ";
			
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	@PutMapping("annonce/modifier")
	public String modifierAnnonce(@RequestBody Annonce annonce) {
		annonceService.update(annonce);
		return "MODIFIÉ";
	}
	
	@GetMapping("annonce/getByUser/{id}")
	public List<Annonce> getBasicAnnoncesByUserId(@PathVariable String id){
		return annonceService.getBasicAnnoncesByUserId(Integer.valueOf(id));
	}

	@PutMapping(value = "annonce/{id}/disable", produces = MediaType.APPLICATION_JSON_VALUE)
	public Annonce desactiverUnAnnonce( @PathVariable int id){
		return annonceService.desactiverUnAnnounce(id);
	}

	@PutMapping(value = "annonce/{id}/enable", produces = MediaType.APPLICATION_JSON_VALUE)
	public Annonce activerUnAnnonce( @PathVariable int id){
		return annonceService.activerUnAnnounce(id);
	}

	@GetMapping("annonces/public")
	public List<Annonce> getAllPublic(){
		return annonceService.getAnnoncesActifs();
	}

	@GetMapping("annonces/all")
	public List<Annonce> getAllAnnonces(){
		return annonceService.getAllAnnonces();
	}

	@DeleteMapping("annonce/delete/{id}")
	public void softDelete(@PathVariable String id){
		annonceService.softDeleteAnnonce(Integer.valueOf(id));
	}

	@GetMapping("/annonce/search{search}")
	public List<Annonce> searchByWord(@RequestParam String search){
		return annonceService.searchByWord(search);
	}

	@GetMapping("/annonce/categorie{id}")
	public List<Annonce> searchByCategorieId(@RequestParam String id){return annonceService.searchByCategorieId(Integer.valueOf(id));}
}
