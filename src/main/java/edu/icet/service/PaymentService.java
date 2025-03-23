package edu.icet.service;

import edu.icet.dto.Payment;

import java.util.List;

public interface PaymentService {
    Payment makePayment(Payment payment);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
    List<Payment> getPaymentByOrderId(Long orderId);
    void updatePaymentStatus(Long paymentId, String status);
    void deletePayment(Long paymentId);
}
