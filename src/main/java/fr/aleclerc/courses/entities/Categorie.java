package fr.aleclerc.courses.entities;

import javax.persistence.Entity;

@Entity
public class Categorie  extends AbstractEntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7855458182575313576L;
	
	private String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
