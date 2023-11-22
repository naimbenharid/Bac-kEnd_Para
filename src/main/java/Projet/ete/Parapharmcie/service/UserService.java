package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.User;
import Projet.ete.Parapharmcie.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepository;
    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User signUp(User user) {
        // Vérifier si l'utilisateur existe déjà
        if (userRepository.findByUseremail(user.getUseremail()) != null) {
            throw new RuntimeException("'utilisateur déjà pris");
        }

        // Encoder le mot de passe avant de l'enregistrer
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Enregistrer l'utilisateur
        return userRepository.save(user);
    }

    public User signIn(String email, String password) {
        // Trouver l'utilisateur par son nom d'utilisateur
        User user = userRepository.findByUsername(email);

        // Vérifier si l'utilisateur existe et si le mot de passe est correct
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Nom d'utilisateur ou mot de passe incorrect");
        }

    }
    public User findByUseremail(String email) {
        return userRepository.findByUseremail(email);
    }


}
