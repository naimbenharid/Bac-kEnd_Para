package Projet.ete.Parapharmcie.repo;

import Projet.ete.Parapharmcie.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findByUsername(String username);
}
