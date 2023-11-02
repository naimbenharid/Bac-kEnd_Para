package Projet.ete.Parapharmcie.repo;

import Projet.ete.Parapharmcie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category , Long> {
}
