package Projet.ete.Parapharmcie.controller;

import Projet.ete.Parapharmcie.model.OrderCustomer;
import Projet.ete.Parapharmcie.model.OrderStatus;
import Projet.ete.Parapharmcie.model.User;
import Projet.ete.Parapharmcie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins="http//localhost:4200")
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    @ResponseBody
    public ResponseEntity<OrderCustomer> createOrder(@RequestBody OrderCustomer order) {
        OrderCustomer savedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderCustomer>> getAllOrders() {
        List<OrderCustomer> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<OrderCustomer> getOrderById(@PathVariable Long id) {
        OrderCustomer order = orderService.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/byOrderDate")
    public ResponseEntity<List<OrderCustomer>> findOrderByOrderDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime orderDate) {
        List<OrderCustomer> orders = orderService.findOrderByOrderDate(orderDate);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/getOrdersByUser/{userId}")
    public ResponseEntity<List<OrderCustomer>> getOrdersByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<OrderCustomer> orders = orderService.getOrdersByUser(user);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/getOrdersByStatus/{status}")
    public ResponseEntity<List<OrderCustomer>> getOrdersByStatus(@PathVariable OrderStatus status) {
        List<OrderCustomer> orders = orderService.getOrdersByStatus(status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PutMapping("updateOrder/{id}")
    public ResponseEntity<OrderCustomer> updateOrder(@PathVariable Long id, @RequestBody OrderCustomer updatedOrder) {
        OrderCustomer updated = orderService.updateOrder(id, updatedOrder);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
