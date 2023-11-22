package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Brand;
import Projet.ete.Parapharmcie.model.OrderCustomer;
import Projet.ete.Parapharmcie.model.OrderStatus;
import Projet.ete.Parapharmcie.model.User;
import Projet.ete.Parapharmcie.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepository;

    @Autowired
    public OrderService(OrderRepo orderRepository)
         {this.orderRepository = orderRepository;}

    public OrderCustomer saveOrder(OrderCustomer order) {
        return orderRepository.save(order);
    }

    public OrderCustomer getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderCustomer> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderCustomer> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public List<OrderCustomer> getOrdersByStatus(OrderStatus orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);
    }

    public List<OrderCustomer> findOrderByOrderDate(LocalDateTime orderDate) {
        return orderRepository.findByOrderDate(orderDate);
    }
    public OrderCustomer UpdateOrder (OrderCustomer order)
    {return orderRepository.save(order);}

       // La commande n'a pas été trouvée

/*
    public double getTotalAmount(Order order) {
        return order.getOrderItems().stream()
                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
    }*/
}
