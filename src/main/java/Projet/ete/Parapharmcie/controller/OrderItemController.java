package Projet.ete.Parapharmcie.controller;

import Projet.ete.Parapharmcie.model.OrderCustomer;
import Projet.ete.Parapharmcie.model.OrderItem;
import Projet.ete.Parapharmcie.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/addOrderItem")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }

    @GetMapping("/getOrderItemsByOrder/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrder(@PathVariable Long orderId) {
        OrderCustomer order = new OrderCustomer();
        order.setId(orderId);
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrder(order);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }


}
