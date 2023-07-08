package com.godin.locationSpring.model;

import javax.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Signalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsignalement")
    private int idSignalement;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "membreutilisateur_id", referencedColumnName = "utilisateur_id")
    private Membre membreUtilisateur;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "annonceid", referencedColumnName = "id")
    private Annonce annonce;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "administrateur_id", referencedColumnName = "utilisateur_id")
    private Administrateur administrateur;

    private String raison;

    @Column(name = "datesignalement")
    private Timestamp dateSignalement;

    public int getIdSignalement() {
        return idSignalement;
    }

    public void setIdSignalement(int idSignalement) {
        this.idSignalement = idSignalement;
    }

    public Membre getMembreUtilisateur() {
        return membreUtilisateur;
    }

    public void setMembreUtilisateur(Membre membreUtilisateur) {
        this.membreUtilisateur = membreUtilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Timestamp getDateSignalement() {
        return dateSignalement;
    }

    public void setDateSignalement(Timestamp dateSignalement) {
        this.dateSignalement = dateSignalement;
    }
}
