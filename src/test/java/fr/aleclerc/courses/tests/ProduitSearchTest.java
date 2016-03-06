package fr.aleclerc.courses.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.aleclerc.courses.CoursesApplication;
import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.services.ProduitService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoursesApplication.class)
public class ProduitSearchTest {
    @Autowired
    ProduitService service;
    
    
    @Test
	public void search() throws Exception {
    	List<Produit> produits = service.searchProduits("po");
    	produits.stream().forEach(System.out::println);
	}
    
}
