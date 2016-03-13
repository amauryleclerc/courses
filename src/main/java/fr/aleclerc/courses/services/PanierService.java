package fr.aleclerc.courses.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aleclerc.courses.entities.Panier;
import fr.aleclerc.courses.entities.ProduitSelect;
import fr.aleclerc.courses.repositories.PanierRepository;
import fr.aleclerc.courses.repositories.ProduitRepository;
import fr.aleclerc.courses.repositories.ProduitSelectRepository;

@Service
public class PanierService {
	@Autowired
	private PanierRepository panierRepo;
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private ProduitSelectRepository produitSelectRepo;
	

	
	public Panier getCurrent(){
		List<Panier> paniers= panierRepo.getCurrent();
		if(paniers != null && !paniers.isEmpty()){
			return paniers.get(0);
		}
		
		if(paniers == null || paniers.isEmpty()){
			Panier panier = new Panier();
			panier.setArchive(false);
			panier.setProduitsSelect(new ArrayList<ProduitSelect>());
			panierRepo.saveAndFlush(panier);
			return panier;
		}
		
		return null;
	}

	
	public void add(ProduitSelect produitSelect) {
		produitSelect.setPanier(this.getCurrent());
		if(produitSelect.getProduit().isNew()){
			produitRepo.saveAndFlush(produitSelect.getProduit());
		}
		produitSelectRepo.saveAndFlush(produitSelect);
	}
	public void archiverCourant(){
		List<Panier> paniers= panierRepo.getCurrent();
		if(paniers != null && !paniers.isEmpty()){
			Panier panier = paniers.get(0);
			 panier.setArchive(true);
			 panier.setDateArchivage(new Date());
			 panierRepo.saveAndFlush(panier);
		}
	}


	public ProduitSelect getProduitSelect(String idProduit) {
		Panier panier = this.getCurrent();
		Optional<ProduitSelect> p = panier.getProduitsSelect().stream().filter(x -> x.getProduit().getId().equals(idProduit) ).findFirst();
		if(p.isPresent()){
			return p.get();
		}
		return null;
	}
}
