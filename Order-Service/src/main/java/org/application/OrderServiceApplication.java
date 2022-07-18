package org.application;

import lombok.RequiredArgsConstructor;
import org.application.entity.Order;
import org.application.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableEurekaClient
@RequiredArgsConstructor
public class OrderServiceApplication implements CommandLineRunner {

    private final OrderRepo orderRepo;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = Order.builder().orderId("ORDER1").productName("Dell Laptop").qty(12).build();
        Order order1 = Order.builder().orderId("ORDER2").productName("Headphone").qty(1).build();
        Order order2 = Order.builder().orderId("ORDER3").productName("Fridge").qty(2).build();
        Order order3 = Order.builder().orderId("ORDER4").productName("TV").qty(3).build();
        List<Order> orders = Arrays.asList(order, order1, order2, order3);
        orderRepo.saveAll(orders);
    }
}
