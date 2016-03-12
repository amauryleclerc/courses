package fr.aleclerc.courses.resources;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aleclerc.courses.entities.Panier;
import fr.aleclerc.courses.entities.ProduitSelect;
import fr.aleclerc.courses.services.PanierService;


@Component
@Path("/panier")
public class PanierResource {
	@Autowired
	private PanierService service;

	@GET
	@Produces("application/json")
	public Panier getCurrentPanier() {
		return service.getCurrent();
	}
	@GET
	@Transactional
	@Path("archiver")
	public Response getArchiverCurrentPanier() {
		 service.archiverCourant();
		 return Response.ok().build();
	}
	@POST
	@Consumes("application/json")
	public Response add(ProduitSelect produit) {
		 service.add(produit);
		 return Response.ok().build();
	}
}
