package com.godin.locationSpring.model;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Annonce {
	public Annonce() {
		super();
		this.dateCreation = new Timestamp(System.currentTimeMillis());
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="utilisateur_proprietaire_id")
	private int utilisateurProprietaireId;

	@Column(name="categorie_id")
	private int categorieId;

	@Column(name="etatoutil_id")
	private int etatOutilId;

	@Nullable
	@Column(name="administrateur_id_activateur")
	private Integer administrateurIdActivateur;

	@Nullable
	@Column(name="administrateur_id_desactivateur")
	private Integer administrateurIdDesactivateur;

    private String titre ;

    private String description;

    private String image;

    private int status;

    @Column(name="date_creation")
    private Timestamp dateCreation;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_proprietaire_id", referencedColumnName = "utilisateur_id", insertable = false, updatable = false)
    private Membre utilisateurProprietaire;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Categorie categorie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etatoutil_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EtatOutil etatOutil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrateur_id_activateur", referencedColumnName = "utilisateur_id", insertable = false, updatable = false)
    private Administrateur administrateurActivateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrateur_id_desactivateur", referencedColumnName = "utilisateur_id", insertable = false, updatable = false)
    private Administrateur administrateurDesactivateur;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "annonceid", referencedColumnName = "id")
    private List<Detail> details;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="annonce_id", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Evaluation> evaluations;
    
	public Membre getUtilisateurProprietaire() {
		return utilisateurProprietaire;
	}

	public void setUtilisateurProprietaire(Membre utilisateurProprietaire) {
		this.utilisateurProprietaire = utilisateurProprietaire;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public EtatOutil getEtatOutil() {
		return etatOutil;
	}

	public void setEtatOutil(EtatOutil etatOutil) {
		this.etatOutil = etatOutil;
	}

	public Administrateur getAdministrateurActivateur() {
		return administrateurActivateur;
	}

	public void setAdministrateurActivateur(Administrateur administrateurActivateur) {
		this.administrateurActivateur = administrateurActivateur;
	}

	public Administrateur getAdministrateurDesactivateur() {
		return administrateurDesactivateur;
	}

	public void setAdministrateurDesactivateur(Administrateur administrateurDesactivateur) {
		this.administrateurDesactivateur = administrateurDesactivateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUtilisateurProprietaireId() {
		return utilisateurProprietaireId;
	}

	public void setUtilisateurProprietaireId(int utilisateurProprietaireId) {
		this.utilisateurProprietaireId = utilisateurProprietaireId;
	}

	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public int getEtatOutilId() {
		return etatOutilId;
	}

	public void setEtatOutilId(int etatOutilId) {
		this.etatOutilId = etatOutilId;
	}

	public Integer getAdministrateurIdActivateur() {
		return administrateurIdActivateur;
	}

	public void setAdministrateurIdActivateur(Integer administrateurIdActivateur) {
		this.administrateurIdActivateur = administrateurIdActivateur;
	}

	public Integer getAdministrateurIdDesactivateur() {
		return administrateurIdDesactivateur;
	}

	public void setAdministrateurIdDesactivateur(Integer administrateurIdDesactivateur) {
		this.administrateurIdDesactivateur = administrateurIdDesactivateur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}





}
