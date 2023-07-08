package com.godin.locationSpring.model.idClass;

import java.io.Serializable;

public class EvaluationId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int membreId;
	private int annonceId;
	public int getMembreId() {
		return membreId;
	}
	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}
	public int getAnnonceId() {
		return annonceId;
	}
	public void setAnnonceId(int annonceId) {
		this.annonceId = annonceId;
	}
	public EvaluationId(int membreId, int annonceId) {
		super();
		this.membreId = membreId;
		this.annonceId = annonceId;
	}
	public EvaluationId() {
		super();
	}
	
	
}
