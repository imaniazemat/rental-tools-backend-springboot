package com.godin.locationSpring.model.idClass;

import java.io.Serializable;
import java.util.Objects;


public class DetailId implements Serializable {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	
	private int annonceId;
	
	private int CategoriePeriodeId;
	
	public DetailId(int annonceId, int categoriePeriodeId) {
		super();
		this.annonceId = annonceId;
		CategoriePeriodeId = categoriePeriodeId;
	}
	public DetailId() {
		super();
	}
	public int getAnnonceId() {
		return annonceId;
	}
	public void setAnnonceId(int annonceId) {
		this.annonceId = annonceId;
	}
	public int getCategoriePeriodeId() {
		return CategoriePeriodeId;
	}
	public void setCategoriePeriodeId(int categoriePeriodeId) {
		CategoriePeriodeId = categoriePeriodeId;
	}
	
	
	@Override
	public int hashCode() {
		
		return Objects.hash(getAnnonceId(), getCategoriePeriodeId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailId other = (DetailId) obj;

		return Objects.equals(getAnnonceId(), other.getAnnonceId())
				&& Objects.equals(getCategoriePeriodeId(), other.getCategoriePeriodeId());
	}

	
}
