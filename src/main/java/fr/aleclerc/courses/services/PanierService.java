package fr.aleclerc.courses.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aleclerc.courses.entities.Panier;
import fr.aleclerc.courses.repositories.PanierRepository;

@Service
public class PanierService {
	@Autowired
	private PanierRepository repo;
	

	@Transactional
	public Panier getCurrent(){
		List<Panier> paniers= repo.getCurrent();
		if(paniers != null && !paniers.isEmpty()){
			return paniers.get(0);
		}
		return null;
	}
}
