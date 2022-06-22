package org.application.service;

import org.application.entity.Order;
import org.application.model.SuccessResponse;

public interface OrderService {
    SuccessResponse createOrder(Order order);
}
