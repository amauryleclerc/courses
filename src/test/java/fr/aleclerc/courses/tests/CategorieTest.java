package fr.aleclerc.courses.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.aleclerc.courses.CoursesApplication;
import fr.aleclerc.courses.entities.Categorie;
import fr.aleclerc.courses.repositories.CategorieRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoursesApplication.class)
public class CategorieTest {
    @Autowired
    CategorieRepository repository;
    
    
    @Test
	public void testName() throws Exception {
    	Categorie c= new Categorie();
    	c.setLibelle("Boulangerie");
    	repository.saveAndFlush(c);
	}
    
}
