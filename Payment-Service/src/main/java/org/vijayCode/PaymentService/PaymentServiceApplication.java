package org.vijayCode.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.vijayCode.PaymentService.entity.Payment;
import org.vijayCode.PaymentService.repo.PaymentRepo;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@EnableEurekaClient
@SpringBootApplication
@RequiredArgsConstructor
public class PaymentServiceApplication implements CommandLineRunner {
    private final PaymentRepo paymentRepo;


    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Payment payment = Payment.builder().paymentStatus("COMPLETED").orderId("ORDER1").amount(5000.0)
                .transactionId(UUID.randomUUID().toString()).build();

        Payment payment2 = Payment.builder().paymentStatus("COMPLETED").orderId("ORDER2").amount(6000.0)
                .transactionId(UUID.randomUUID().toString()).build();


        Payment payment3 = Payment.builder().paymentStatus("COMPLETED").orderId("ORDER3").amount(7000.0)
                .transactionId(UUID.randomUUID().toString()).build();

        Payment payment4 = Payment.builder().paymentStatus("COMPLETED").orderId("ORDER5").amount(8000.0)
                .transactionId(UUID.randomUUID().toString()).build();

        List<Payment> payments = Arrays.asList(payment, payment2, payment3, payment4);
        paymentRepo.saveAll(payments);


    }
}
