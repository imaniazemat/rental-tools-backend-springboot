package com.godin.locationSpring.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmessage")
	private int idMessage;
	private int expediteurId;
	private int recepteurId;
	private String contenu;
	@Column(name="dateenvol")
	private Timestamp dateEnvoi;
	
	
	public Message() {
		super();
	}
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public int getExpediteurId() {
		return expediteurId;
	}
	public void setExpediteurId(int expediteurId) {
		this.expediteurId = expediteurId;
	}
	public int getRecepteurId() {
		return recepteurId;
	}
	public void setRecepteurId(int recepteurId) {
		this.recepteurId = recepteurId;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Timestamp getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Timestamp dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	
	
}
