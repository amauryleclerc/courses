package fr.aleclerc.courses.repositories;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.aleclerc.courses.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, String> {
	
	
	   @Query("SELECT p FROM Produit p WHERE p.libelle LIKE :search%")
	    public List<Produit> searchWithJPQLQuery(@Param("search") String search, Pageable pageRequest);
	 
}
