package fr.aleclerc.courses.tests;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.aleclerc.courses.CoursesApplication;
import fr.aleclerc.courses.entities.Panier;
import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.entities.ProduitSelect;
import fr.aleclerc.courses.repositories.PanierRepository;
import fr.aleclerc.courses.repositories.ProduitRepository;
import fr.aleclerc.courses.repositories.ProduitSelectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoursesApplication.class)
public class PanierTest {
	@Autowired
	PanierRepository panierRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ProduitSelectRepository produitSelectRepository;
	@Test
	public void archiver() throws Exception {
		List<Panier> paniers = panierRepository.findAll();
		System.out.println(paniers.size());
		for (Panier panier : paniers) {
			panier.setArchive(true);
			panierRepository.save(panier);
		}
		panierRepository.flush();
	}

	@Test
	public void add() throws Exception {
		Panier panier = new Panier();
		panier.setArchive(false);
		panier.setProduitsSelect(new ArrayList<ProduitSelect>());
		panier = panierRepository.saveAndFlush(panier);
		List<Produit> produits = produitRepository.findAll();
		for(Produit produit : produits){
			ProduitSelect ps= new ProduitSelect();
			ps.setPris(false);
			ps.setProduit(produit);
			ps.setQuantite(1);
			ps.setPanier(panier);
			produitSelectRepository.save(ps);
		}

		produitSelectRepository.flush();
	}

	@Test
	@Transactional
	public void list() throws Exception {
		List<Panier> paniers = panierRepository.getCurrent();
		if(paniers != null && !paniers.isEmpty()){
		List<ProduitSelect> produits = paniers.get(0).getProduitsSelect();
		for(ProduitSelect produit : produits){
			System.out.println(produit.getProduit().getLibelle());
		}
		}
		
		
	}
}
