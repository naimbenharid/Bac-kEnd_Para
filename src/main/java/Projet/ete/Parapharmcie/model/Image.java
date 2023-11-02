package Projet.ete.Parapharmcie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // Lien vers l'image

    @ManyToOne
    @JoinColumn(name = "product")
   // @JsonBackReference
    private Product product;


}
