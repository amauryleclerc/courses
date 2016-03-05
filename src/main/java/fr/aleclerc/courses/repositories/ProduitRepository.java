package fr.aleclerc.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aleclerc.courses.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, String> {

}
