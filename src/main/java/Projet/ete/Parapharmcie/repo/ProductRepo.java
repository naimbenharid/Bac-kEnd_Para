package Projet.ete.Parapharmcie.repo;

import Projet.ete.Parapharmcie.model.Category;
import Projet.ete.Parapharmcie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByCategory(Category category);
   List<Product> findByPrice(double price);
    List<Product> findByQte(Integer qte);
}
