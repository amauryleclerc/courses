package fr.aleclerc.courses.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aleclerc.courses.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, String> {

	public List<Categorie> findCategorieByPosition(Integer position);
}
