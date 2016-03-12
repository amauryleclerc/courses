package fr.aleclerc.courses.services;

import java.util.List;

import javax.transaction.Transactional;

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
	

	@Transactional
	public Panier getCurrent(){
		List<Panier> paniers= panierRepo.getCurrent();
		if(paniers != null && !paniers.isEmpty()){
			return paniers.get(0);
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
}
