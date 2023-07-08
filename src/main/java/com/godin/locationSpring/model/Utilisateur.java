package com.godin.locationSpring.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String courriel;
    private BigInteger telephone;
    private String password;
    @Column(name = "num_rue")
    private int numRue;
    @Column(name = "nom_rue")
    private String nomRue;
    private String ville;
    private String province;
    @Column(name = "codepostal")
    private String codePostal;
//    private String token;

    public Utilisateur() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public BigInteger getTelephone() {
        return telephone;
    }

    public void setTelephone(BigInteger telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", courriel='" + courriel + '\'' +
                ", telephone=" + telephone +
                ", password='" + password + '\'' +
                ", numRue=" + numRue +
                ", nomRue='" + nomRue + '\'' +
                ", ville='" + ville + '\'' +
                ", province='" + province + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }
}
