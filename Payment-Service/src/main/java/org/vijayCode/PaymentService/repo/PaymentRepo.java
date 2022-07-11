package org.vijayCode.PaymentService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vijayCode.PaymentService.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
