package com.godin.locationSpring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.godin.locationSpring.model.idClass.EvaluationId;

@Entity
@Table(name="evaluation")
@IdClass(EvaluationId.class)
public class Evaluation {
	@Id
	@Column(name="Annonce_id")
	private int annonceId;
	@Id
	@Column(name="Membre_id")
	private int membreId;
	
	private String commentaire;
	
	@Column(name="dateevaluation")
	private Timestamp dateEvaluation;
	
	@Column(name="note")
	private int note;

	public Evaluation() {
		super();
	}

	public int getAnnonceId() {
		return annonceId;
	}

	public void setAnnonceId(int annonceId) {
		this.annonceId = annonceId;
	}

	public int getMembreId() {
		return membreId;
	}

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Timestamp getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Timestamp dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	

}
