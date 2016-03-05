package fr.aleclerc.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aleclerc.courses.entities.ProduitSelect;

public interface ProduitSelectRepository extends JpaRepository<ProduitSelect, String> {

}
