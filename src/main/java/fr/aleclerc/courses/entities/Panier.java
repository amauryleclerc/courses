package fr.aleclerc.courses.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Panier extends AbstractEntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8616634038191718769L;
	@OneToMany( fetch = FetchType.EAGER,mappedBy="panier")
	private List<ProduitSelect> produitsSelect;
	@Column
	private Boolean archive;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateArchivage;
	public List<ProduitSelect> getProduitsSelect() {
		return produitsSelect;
	}
	public void setProduitsSelect(List<ProduitSelect> produitsSelect) {
		this.produitsSelect = produitsSelect;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Date getDateArchivage() {
		return dateArchivage;
	}
	public void setDateArchivage(Date dateArchivage) {
		this.dateArchivage = dateArchivage;
	}

}
