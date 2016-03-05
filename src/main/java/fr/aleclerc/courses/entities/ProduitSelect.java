package fr.aleclerc.courses.entities;

import javax.persistence.Entity;

@Entity
public class ProduitSelect extends AbstractEntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8613668231303877346L;
	private Panier panier;
	private Produit produit;
	private Boolean pris;
	private Integer quantite;
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Boolean getPris() {
		return pris;
	}
	public void setPris(Boolean pris) {
		this.pris = pris;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}

}
