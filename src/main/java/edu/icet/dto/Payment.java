package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private Long paymentId;
    private Long orderId;
    private Double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate paymentDate;
}
