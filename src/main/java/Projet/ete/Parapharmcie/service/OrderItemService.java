package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.OrderCustomer;
import Projet.ete.Parapharmcie.model.OrderItem;
import Projet.ete.Parapharmcie.repo.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepo orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepo orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getOrderItemsByOrder(OrderCustomer order) {
        return orderItemRepository.findByOrder(order);
    }



}
