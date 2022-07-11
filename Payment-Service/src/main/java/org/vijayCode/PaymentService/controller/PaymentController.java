package org.vijayCode.PaymentService.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.vijayCode.PaymentService.service.PaymentService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController implements  PaymentApi{

    private final PaymentService paymentService;
}
