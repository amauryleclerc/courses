package fr.aleclerc.courses.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.repositories.ProduitRepository;
import fr.aleclerc.courses.services.ProduitService;

@Component
@Path("/produits")
public class ProduitResource {
	@Autowired
	private ProduitService service;

	@GET
	@Produces("application/json")
	public List<Produit> getProduits() {
		return service.findAll();
	}
	@GET
	@Produces("application/json")
	@Path("search")
	public List<Produit> searchProduits(@QueryParam("search") String search) {
		return service.searchProduits(search);
	}
}
