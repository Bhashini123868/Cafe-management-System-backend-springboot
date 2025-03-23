package edu.icet.service.impl;

import edu.icet.dto.Payment;
import edu.icet.entity.PaymentEntity;
import edu.icet.repository.PaymentRepository;
import edu.icet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    private ModelMapper mapper;

    @Override
    public Payment makePayment(Payment payment) {
        {
            PaymentEntity entity = mapper.map(payment, PaymentEntity.class);
            PaymentEntity savedEntity = paymentRepository.save(entity);
        return mapper.map(savedEntity, Payment.class);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        return List.of();
    }

    @Override
    public List<Payment> getPaymentByOrderId(Long orderId) {
        return List.of();
    }

    @Override
    public void updatePaymentStatus(Long paymentId, String status) {

    }

    @Override
    public void deletePayment(Long paymentId) {

    }
}
