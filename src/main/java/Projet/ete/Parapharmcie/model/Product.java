package Projet.ete.Parapharmcie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private Integer qte ;

    @ManyToOne
    private Brand brand;

    @OneToMany
    @JsonIgnore
    private List<Image> images = new ArrayList<>();

    @ManyToOne
    private Category category;

    @OneToMany
    @JsonIgnore
    private List<OrderItem> orderItems= new ArrayList<>();




}
