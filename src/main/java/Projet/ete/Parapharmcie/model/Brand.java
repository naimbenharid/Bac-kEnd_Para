package Projet.ete.Parapharmcie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;


    @OneToMany
    @Column(name = "products")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();


}
