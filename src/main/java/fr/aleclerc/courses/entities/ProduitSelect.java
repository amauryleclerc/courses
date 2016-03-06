package fr.aleclerc.courses.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProduitSelect extends AbstractEntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8613668231303877346L;
	@ManyToOne
	@JoinColumn(name="panier_id")
	@JsonIgnore
	private Panier panier;
	@ManyToOne
	@JoinColumn(name="produit_id")
	private Produit produit;
	@Column
	private Boolean pris;
	@Column
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
