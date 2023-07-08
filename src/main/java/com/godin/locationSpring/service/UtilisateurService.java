package com.godin.locationSpring.service;

import com.godin.locationSpring.model.Utilisateur;
import com.godin.locationSpring.repository.UtilisateurRepository;
import com.godin.locationSpring.vo.ErrorCode;
import com.godin.locationSpring.vo.LoginUtilisateurVo;
import com.godin.locationSpring.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.util.StringUtils;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    private TokenService tokenService;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public int save(Utilisateur u) {
        return utilisateurRepository.save(u).getId();
    }

    public Utilisateur findUtilisateurByCourriel(String courriel) {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByCourriel(courriel);
        return utilisateur;
    }

    public Utilisateur findUtilisateurByCourrielAndPassword(String courriel, String password) {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByCourrielAndPassword(courriel, password);
        return utilisateur;
    }

    public Utilisateur findById(int id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()) {
            Utilisateur utilisateur = utilisateurOptional.get();
            return utilisateur;
        }
        return null;
    }

    public Result findUtilisateurByToekn(String token) {
        int userId = tokenService.checkToken(token);
        Utilisateur utilisateur = findById(userId);

        if (utilisateur == null) {
            Result.fail(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg());
        }

        LoginUtilisateurVo loginUtilisateurVo = new LoginUtilisateurVo();
        loginUtilisateurVo.setId(utilisateur.getId());
        loginUtilisateurVo.setNom(utilisateur.getNom());
        loginUtilisateurVo.setPrenom(utilisateur.getPrenom());
        loginUtilisateurVo.setCourriel(utilisateur.getCourriel());
        loginUtilisateurVo.setTelephone(utilisateur.getTelephone());
        loginUtilisateurVo.setNumRue(utilisateur.getNumRue());
        loginUtilisateurVo.setNomRue(utilisateur.getNomRue());
        loginUtilisateurVo.setVille(utilisateur.getVille());
        loginUtilisateurVo.setProvince(utilisateur.getProvince());
        loginUtilisateurVo.setCodePostal(utilisateur.getCodePostal());
        loginUtilisateurVo.setToken(token);

        return Result.success(loginUtilisateurVo);
    }

    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(id).get();
    }

    public String getNom(int id) {
        Utilisateur u = utilisateurRepository.findById(id).get();
        return (u.getPrenom()).toUpperCase();
    }

    public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateur2 = utilisateurRepository.findById(utilisateur.getId()).get();
        utilisateur2 = utilisateur;
        utilisateurRepository.save(utilisateur2);
        return utilisateur2;
    }
}
