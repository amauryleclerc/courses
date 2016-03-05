package fr.aleclerc.courses.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.repositories.ProduitRepository;

@Component
@Path("/produits")
public class ProduitResource {
	@Autowired
	private ProduitRepository repo;

	@GET
	@Produces("application/json")
	public List<Produit> getProduits() {
		return repo.findAll();
	}
}
