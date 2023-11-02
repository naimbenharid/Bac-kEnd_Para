package Projet.ete.Parapharmcie.repo;

import Projet.ete.Parapharmcie.model.Image;
import Projet.ete.Parapharmcie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image,Long> {
    List<Image> findByProduct(Product product);

    Image findImageById(Long id);

}
