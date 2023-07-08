package com.godin.locationSpring.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="membre")
public class Membre implements Serializable{

	private boolean status;

	@Column(name="utilisateur_id")
	@Id
	private int utilisateurId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrateur_id_desactivateur", referencedColumnName = "utilisateur_id")
    private Administrateur administrateurDesactivateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrateur_id_activateur", referencedColumnName = "utilisateur_id")
    private Administrateur administrateurActivateur;

    public Membre() {
    }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Administrateur getAdministrateurDesactivateur() {
		return administrateurDesactivateur;
	}

	public void setAdministrateurDesactivateur(Administrateur administrateurDesactivateur) {
		this.administrateurDesactivateur = administrateurDesactivateur;
	}

	public Administrateur getAdministrateurActivateur() {
		return administrateurActivateur;
	}

	public void setAdministrateurActivateur(Administrateur administrateurActivateur) {
		this.administrateurActivateur = administrateurActivateur;
	}



}
