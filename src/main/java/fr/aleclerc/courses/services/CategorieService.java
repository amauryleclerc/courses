package fr.aleclerc.courses.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aleclerc.courses.entities.Categorie;
import fr.aleclerc.courses.repositories.CategorieRepository;

@Service
public class CategorieService {
	@Autowired
	private CategorieRepository repo;

	@Transactional
	public List<Categorie> getAll() {
		return repo.findAll();
	}

	@Transactional
	public Categorie add(Categorie cat) {
		cat.setPostion(this.getAll().size());
		return repo.saveAndFlush(cat);
	}

	public void delete(String id) {
		repo.delete(id);
	}

	public Categorie update(Categorie categorie) {
		return repo.saveAndFlush(categorie);
	}

	public void up(Categorie categorie) {
		Integer oldPosition = categorie.getPosition();
		this.changePosition(categorie, oldPosition + 1, oldPosition);
	}

	public void down(Categorie categorie) {
		Integer oldPosition = categorie.getPosition();
		this.changePosition(categorie, oldPosition - 1, oldPosition);
	}

	private void changePosition(Categorie categorie, Integer newPosition, Integer oldPosition) {
		List<Categorie> categories = repo.findCategorieByPosition(newPosition);
		categories.stream().forEach((element) -> {
			element.setPostion(oldPosition);
			repo.save(element);
		});
		if (!categories.isEmpty()) {
			categorie.setPostion(newPosition);
			repo.save(categorie);
			repo.flush();
		}
	}
}
