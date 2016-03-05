package fr.aleclerc.courses.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.aleclerc.courses.CoursesApplication;
import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.repositories.ProduitRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoursesApplication.class)
@WebIntegrationTest
public class ProduitTest {
    @Autowired
    ProduitRepository repository;
    
    
    @Test
	public void testName() throws Exception {
    	Produit p = new Produit();
    	p.setLibelle("pomme");
    	repository.saveAndFlush(p);
	}
    
}
