package fr.aleclerc.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aleclerc.courses.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, String> {

}
