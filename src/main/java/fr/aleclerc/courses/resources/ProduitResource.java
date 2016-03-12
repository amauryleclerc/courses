package fr.aleclerc.courses.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.aleclerc.courses.entities.Produit;
import fr.aleclerc.courses.services.ProduitService;
@CrossOrigin(maxAge = 3600)
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
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Produit updateProduit(Produit produit) {
		return service.update(produit);
	}
}
