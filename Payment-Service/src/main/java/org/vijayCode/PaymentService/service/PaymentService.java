package org.vijayCode.PaymentService.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.vijayCode.PaymentService.repo.PaymentRepo;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepo paymentRepo;
}
