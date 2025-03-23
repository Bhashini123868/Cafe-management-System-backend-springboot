package edu.icet.controller;

import edu.icet.dto.Order;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("place-order")
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
    @GetMapping("/get-orders-by-user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId){
        return orderService.getOrdersByUser(userId);
    }
    @GetMapping("/get-order-by-id/{id}")
    public Order getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }
    @PatchMapping("/update-order-status/{orderId}")
    public void updateOrderStatus(@PathVariable Long orderId, @RequestParam String status){
        orderService.updateOrderStatus(orderId, status);
    }
    @GetMapping("/get-orders-by-status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status){
        return orderService.getOrderByStatus(status);
    }
}
