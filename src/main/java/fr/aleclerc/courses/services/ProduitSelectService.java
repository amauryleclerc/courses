package fr.aleclerc.courses.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aleclerc.courses.repositories.ProduitSelectRepository;


@Service
public class ProduitSelectService {
	@Autowired
	private ProduitSelectRepository repo;
	
	

	@Transactional
	public void delete(String id) {
		 repo.delete(id);
	}
}

