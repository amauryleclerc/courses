package fr.aleclerc.courses.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit extends AbstractEntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6296789345664136108L;
	@Column
	private String libelle;
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
