package com.godin.locationSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.godin.locationSpring.model.Annonce;
import com.godin.locationSpring.model.Detail;
import com.godin.locationSpring.repository.AnnonceRepository;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    DetailService detailService;

    public Annonce getOneAnnonce() {
        Annonce annonce = annonceRepository.findAll().get(1);
        return annonce;
    }

    public Annonce getAnnonce(int id) {
        Optional<Annonce> annonce = annonceRepository.findById(id);

        if (annonce.get().getStatus() != 2) return annonce.get();
        else return new Annonce();
    }

    public int insert(Map<String, Object> body) {
        Annonce annonce = new Annonce();
        annonce.setUtilisateurProprietaireId((int) body.get("utilisateurProprietaireId"));
        annonce.setCategorieId((int) body.get("categorieId"));
        annonce.setEtatOutilId((int) body.get("etatOutilId"));
        annonce.setAdministrateurIdActivateur(null);
        annonce.setAdministrateurIdDesactivateur(null);
        annonce.setTitre((String) body.get("titre"));
        annonce.setDescription((String) body.get("description"));
        annonce.setImage((String) body.get("image"));
        annonce.setStatus(1);
        int i = annonceRepository.save(annonce).getId();
        return i;
    }

    public void update(Annonce annonce) {
        detailService.deleteByAnnonceId(annonce.getId());

        annonce.getDetails().forEach(x -> {
            Detail detail = new Detail(x.getAnnonceId(), x.getCategoriePeriodeId(), x.getPrix());
            detailService.insert(detail);
        });

        Annonce annonce2 = annonceRepository.findById(annonce.getId()).get();

        annonce2.setTitre(annonce.getTitre());
        annonce2.setDescription(annonce.getDescription());
        annonce2.setImage(annonce.getImage());
        annonce2.setCategorieId(annonce.getCategorieId());
        annonce2.setEtatOutilId(annonce.getEtatOutilId());

        annonceRepository.save(annonce2);
    }

    public List<Annonce> getBasicAnnoncesByUserId(int userId) {
        List<Annonce> listAnnonces = new ArrayList<>();
        annonceRepository.findByUtilisateurProprietaireId(userId).forEach(x -> {
            Annonce annonce = new Annonce();
            annonce.setId(x.getId());
            annonce.setTitre(x.getTitre());
            annonce.setDateCreation(x.getDateCreation());
            annonce.setStatus(x.getStatus());
            annonce.setAdministrateurIdDesactivateur(x.getAdministrateurIdDesactivateur());
            listAnnonces.add(annonce);
        });
        listAnnonces.removeIf(x -> x.getStatus() == 2);
        return listAnnonces;
    }

    public Annonce desactiverUnAnnounce(int id) {
        Annonce annonce = annonceRepository.findById(id).orElse(new Annonce());
        annonce.setStatus(0);
        return annonceRepository.save(annonce);
    }

    public Annonce activerUnAnnounce(int id) {
        Annonce annonce = annonceRepository.findById(id).orElse(new Annonce());
        annonce.setStatus(1);
        return annonceRepository.save(annonce);
    }

    public void softDeleteAnnonce(int id) {
        Annonce annonce = annonceRepository.findById((id)).get();
        annonce.setStatus(2);
        annonceRepository.save(annonce);
    }

    public List<Annonce> getAnnoncesActifs() {
        List<Annonce> liste = annonceRepository.findAll();
        liste.removeIf(x -> (x.getStatus() != 1));
        return liste;
    }

    public List<Annonce> getAllAnnonces() {
        List<Annonce> liste = annonceRepository.findAll();
        return liste;
    }


    public List<Annonce> searchByWord(String word) {
        return annonceRepository.searchByWord(word);
    }

    public List<Annonce> searchByCategorieId(int categorieId) {
        return annonceRepository.searchByCategorieId(categorieId);
    }

}
