package fr.aleclerc.courses.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aleclerc.courses.entities.Categorie;
import fr.aleclerc.courses.services.CategorieService;

@Component
@Path("/categories")
public class CategoriesResource {
	@Autowired
	private CategorieService service;

	@GET
	@Produces("application/json")
	public List<Categorie> getCategories() {
		return service.getAll();
	}
}
