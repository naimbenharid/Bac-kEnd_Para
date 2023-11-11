package Projet.ete.Parapharmcie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity

public class OrderCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private String deliveryAddress;
    private Integer totalAmount;
    @Enumerated
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany
    @JsonIgnore
    private List<OrderItem> orderItems = new ArrayList<>();

}
