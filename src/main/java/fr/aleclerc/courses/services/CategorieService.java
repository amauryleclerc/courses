package fr.aleclerc.courses.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aleclerc.courses.entities.Categorie;
import fr.aleclerc.courses.repositories.CategorieRepository;

@Service
public class CategorieService {
	@Autowired
	private CategorieRepository repo;
	

	@Transactional
	public List<Categorie> getAll(){
		return repo.findAll();
	}
	
	@Transactional
	public Categorie add(Categorie cat){
		return repo.saveAndFlush(cat);
	}

	public void delete(String id) {
		repo.delete(id);
	}

	public Categorie update(Categorie categorie) {
		return repo.saveAndFlush(categorie);
	}
}
