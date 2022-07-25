package org.application.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.vijayCode.model.PaymentResponse;

@FeignClient(value = "payment-service", url = "http://payment-service/")
public interface FiegnCall {

    @PostMapping("/payment")
    PaymentResponse payment(@RequestBody PaymentResponse payment) throws JsonProcessingException;

    @GetMapping("/{orderId}")
    PaymentResponse findPaymentHistoryByOrderId(@PathVariable String orderId);
}
