package Projet.ete.Parapharmcie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ParapharmcieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParapharmcieApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder getBCE()
	{
		return new BCryptPasswordEncoder(); //singelton
	}

}
