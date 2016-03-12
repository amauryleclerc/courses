package fr.aleclerc.courses.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.aleclerc.courses.entities.Categorie;
import fr.aleclerc.courses.services.CategorieService;
@CrossOrigin(maxAge = 3600)
@Component
@Path("/categorie")
public class CategorieResource {
	@Autowired
	private CategorieService service;

	@POST
	@Consumes("application/json")
	public Response add(Categorie cat) {
		System.out.println(cat.getLibelle());
		 service.add(cat);
		 return Response.ok().build();
	}
}
