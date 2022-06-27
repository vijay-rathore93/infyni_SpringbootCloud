package org.application.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.application.entity.Order;
import org.application.repo.OrderRepo;
import org.application.utility.CommonCode;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.vijayCode.api.OrderApiDelegate;
import org.vijayCode.model.OrderResponse;
import org.vijayCode.model.SuccessResponse;

import java.util.UUID;

import static org.application.utility.Constants.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderApiDelegate {
    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<SuccessResponse> createOrder(OrderResponse orderResponse) {
        orderResponse.setOrderId(UUID.randomUUID().toString());
        Order order=modelMapper.map(orderResponse,Order.class);
        Order created= orderRepo.save(order);
        SuccessResponse successResponse=CommonCode.getSuccessResponse(ORDER_CREATE,
                ORDER_CREATE_CODE,
                created.getOrderId(),
                ORDER_ID_KEY_TYPE);
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }
}

