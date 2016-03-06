package fr.aleclerc.courses.resources;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aleclerc.courses.entities.Panier;
import fr.aleclerc.courses.services.PanierService;


@Component
@Path("/panier")
public class PanierResource {
	@Autowired
	private PanierService service;

	@GET
	@Produces("application/json")
	@Transactional
	public Panier getCurrentPanier() {
		return service.getCurrent();
	}
}
