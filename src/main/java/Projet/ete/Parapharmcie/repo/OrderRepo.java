package Projet.ete.Parapharmcie.repo;

import Projet.ete.Parapharmcie.model.OrderCustomer;
import Projet.ete.Parapharmcie.model.OrderStatus;
import Projet.ete.Parapharmcie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepo extends JpaRepository<OrderCustomer,Long> {
    List<OrderCustomer> findByUser(User user);

    List<OrderCustomer> findByOrderStatus(OrderStatus orderStatus);

    List<OrderCustomer> findByOrderDate(LocalDateTime orderDate);

}
