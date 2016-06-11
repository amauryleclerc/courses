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
	@Column
	private String unite;
	@Column
	private String commentaire;
	@Column
	private boolean promo;
	
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
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public boolean isPromo() {
		return promo;
	}
	public void setPromo(boolean promo) {
		this.promo = promo;
	}

}
