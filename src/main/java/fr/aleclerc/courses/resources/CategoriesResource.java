package fr.aleclerc.courses.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	@POST
	@Consumes("application/json")
	public Response add(Categorie cat) {
		System.out.println(cat.getLibelle());
		 service.add(cat);
		 return Response.ok().build();
	}
	@POST
	@Path("up")
	@Consumes("application/json")
	public Response up(Categorie cat) {
		 service.up(cat);
		 return Response.ok().build();
	}
	@POST
	@Path("down")
	@Consumes("application/json")
	public Response down(Categorie cat) {
		 service.down(cat);
		 return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {
		 service.delete(id);
		 return Response.ok().build();
		
	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Categorie update(Categorie categorie) {
		return service.update(categorie);
	}
}
