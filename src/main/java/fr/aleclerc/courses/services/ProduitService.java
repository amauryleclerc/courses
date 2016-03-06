package fr.aleclerc.courses.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.repositories.ProduitRepository;


@Service
public class ProduitService {
	@Autowired
	private ProduitRepository repo;
	
	
	@Transactional
	public List<Produit> searchProduits(String search){
		return repo.searchWithJPQLQuery(search, new PageRequest(0, 10));
	}

	@Transactional
	public List<Produit> findAll() {
		return repo.findAll();
	}
}

