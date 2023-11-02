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

    @Column(name = "products")
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
   // @JsonManagedReference
    private List<Product> products = new ArrayList<>();


}
