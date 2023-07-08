package com.godin.locationSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etatoutil")
public class EtatOutil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String titre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

	public EtatOutil() {
		super();
	}
    
}
