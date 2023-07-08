package com.godin.locationSpring.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.godin.locationSpring.model.Categorie;
import com.godin.locationSpring.model.CategoriePeriode;
import com.godin.locationSpring.model.Detail;
import com.godin.locationSpring.model.EtatOutil;
import com.godin.locationSpring.model.Evaluation;
import com.godin.locationSpring.service.CategoriePeriodeService;
import com.godin.locationSpring.service.CategorieService;
import com.godin.locationSpring.service.DetailService;
import com.godin.locationSpring.service.EtatOutilService;
import com.godin.locationSpring.service.EvaluationService;
import com.godin.locationSpring.service.UtilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UtilitiesController {
	@Autowired 
	CategorieService categorieService;
	
	@Autowired
	EtatOutilService etatOutilService;
	
	@Autowired
	CategoriePeriodeService categoriePeriodeService;
	
	@Autowired
	DetailService detailService;
	
	@Autowired
	EvaluationService evaluationService;
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@GetMapping("/categories")
	public List<Categorie> getAllCategories(){
		return categorieService.getAll();
	}
	
	@GetMapping("/etatsoutils")
	public List<EtatOutil> getAllEtatOutils(){
		return etatOutilService.getAll();
	}
	
	@GetMapping("/categorieperiodes")
	public List<CategoriePeriode> getAllCategoriePeriodes(){
		return categoriePeriodeService.getAll();
	}
	
	@GetMapping("/details")
	public List<Detail> getAllDetails(){
		return detailService.getAll();
	}
	
	@GetMapping("/evaluations")
	public List<Evaluation> getAll(){
		return evaluationService.getAll();
	}
	
	@GetMapping("/evaluation/{idannonce}")
	public Object getEvaluationAnnonce(@PathVariable String idannonce) {
		List<Evaluation> evaluations = evaluationService.getByAnnonceId(Integer.valueOf(idannonce));
		List<Object> object = new ArrayList<Object>();
		evaluations.forEach(x->{
			HashMap<String, Object> map = new HashMap<>();
			map.put("annonceId", x.getAnnonceId());
			map.put("membreId", x.getMembreId());
			map.put("commentaire", x.getCommentaire());
			map.put("dateEvaluation", x.getDateEvaluation().toString().substring(0, 16));
			map.put("note", x.getNote());
			map.put("nom", getNomMembre(String.valueOf(x.getMembreId())));
			object.add(map);
			
		});
		return object;
	}
	
	
	@PostMapping("/evaluation/insert")
	public void evaluerAnnonce(@RequestBody Map<String, Object> body) {
		evaluationService.insert(body);
	}
	
	@GetMapping("/nommembre/{id}")
	public String getNomMembre(@PathVariable String id) {
		return utilisateurService.getNom(Integer.valueOf(id));
	}
	

}
