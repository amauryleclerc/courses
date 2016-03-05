package fr.aleclerc.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aleclerc.courses.entities.Panier;

public interface PanierRepository extends JpaRepository<Panier, String> {

}
