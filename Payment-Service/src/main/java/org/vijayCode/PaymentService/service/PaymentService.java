package org.vijayCode.PaymentService.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.vijayCode.PaymentService.entity.Payment;
import org.vijayCode.PaymentService.repo.PaymentRepo;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public Payment makePayment(Payment payment) throws JsonProcessingException {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());

        return paymentRepo.save(payment);
    }


    private String paymentProcessing(){
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(String orderId) {
        Payment payment=paymentRepo.findByOrderId(orderId);
        return payment ;
    }
}
