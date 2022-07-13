package org.vijayCode.PaymentService.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.vijayCode.PaymentService.entity.Payment;
import org.vijayCode.PaymentService.service.PaymentService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public Payment payment(@RequestBody Payment payment) throws JsonProcessingException {
        return paymentService.makePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable String orderId) {
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }
}
