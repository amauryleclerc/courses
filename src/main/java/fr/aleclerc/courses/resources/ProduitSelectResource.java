package fr.aleclerc.courses.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.aleclerc.courses.services.ProduitSelectService;

@Component
@Path("/produits-select")
public class ProduitSelectResource {
	@Autowired
	private ProduitSelectService service;


	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {
		 service.delete(id);
		 return Response.ok().build();
		
	}
	
}
