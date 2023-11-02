package Projet.ete.Parapharmcie.repo;

import Projet.ete.Parapharmcie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
