package edu.icet.service.impl;

import edu.icet.dto.Order;
import edu.icet.entity.OrderEntity;
import edu.icet.repository.OrderRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    final ModelMapper mapper;
    @Override
    public Order placeOrder(Order order) {
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
        orderEntity.setOrderStatus("Pending");
        OrderService savedOrder = (OrderService) orderRepository.save(orderEntity);
        return mapper.map(savedOrder, Order.class);
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(order-> mapper.map(order, Order.class))
                .collect(Collectors.toCollection(null));
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(order->mapper.map(order, Order.class))
                .orElse(null);
    }

    @Override
    public void updateOrderStatus(Long orderId, String status) {
        orderRepository.findById(orderId).ifPresent(order->{
            order.setOrderStatus(status);
            orderRepository.save(order);
        });
    }
}
