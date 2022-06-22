package org.application.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.application.entity.Order;
import org.application.model.SuccessResponse;
import org.application.repo.OrderRepo;
import org.application.service.OrderService;
import org.application.utility.CommonCode;
import org.application.utility.Constants;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public SuccessResponse createOrder(Order order) {
        order.setOrderID(UUID.randomUUID().toString());
        Order orderCreated= orderRepo.save(order);
        return CommonCode.getSuccessResponse(Constants.ORDER_CREATE,
                Constants.ORDER_CREATE_CODE,
                orderCreated.getOrderID(),
                Constants.ORDER_ID_KEY_TYPE);
    }
}
