package fr.aleclerc.courses.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Categorie extends AbstractEntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7855458182575313576L;
	@Column
	private String libelle;
	@Column
	private Integer position;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPostion(Integer postion) {
		this.position = postion;
	}

}
