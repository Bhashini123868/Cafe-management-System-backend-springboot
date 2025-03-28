package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Long orderId;
    private Long userId;
    private List<MenuItem> menuItems;
    private Double totalPrice;
    private String orderStatus;
    private LocalDate orderDate;
}
