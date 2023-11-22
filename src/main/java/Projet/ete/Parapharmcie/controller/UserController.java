package Projet.ete.Parapharmcie.controller;

import Projet.ete.Parapharmcie.model.User;
import Projet.ete.Parapharmcie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @ResponseBody
    @PostMapping("/signin")
    public User signIn(@RequestBody User user) {
        return userService.signIn(user.getUseremail(),user.getPassword()) ;
    }}





