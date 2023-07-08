package com.godin.locationSpring.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class Administrateur implements Serializable{
	public Administrateur() {
		super();
	}
	
    @Id
    @Column(name="utilisateur_id")
    private int utilisateurId;

    @Column(name = "dateembauche")
    private Timestamp dateEmbauche;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Utilisateur utilisateur;

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Timestamp getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Timestamp dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

    
}
