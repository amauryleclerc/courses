package fr.aleclerc.courses.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.aleclerc.courses.entities.Panier;

public interface PanierRepository extends JpaRepository<Panier, String> {
	
	@Query("select p from Panier p where p.archive = false")
	public List<Panier> getCurrent();
}
