package edu.icet.service;

import edu.icet.dto.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Order order);
    List<Order> getOrdersByUser(Long userId);
    Order getOrderById(Long orderId);
    void updateOrderStatus(Long orderId);
    List<Order> getOrderByStatus(String status);

    void updateOrderStatus(Long orderId, String status);
}
