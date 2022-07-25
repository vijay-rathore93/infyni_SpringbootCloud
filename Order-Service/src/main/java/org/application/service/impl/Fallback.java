package org.application.service.impl;

import org.application.exception.OrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.vijayCode.model.OrderResponse;

public abstract class Fallback {

    public OrderResponse paymentServiceFallback(String orderId, Exception exception){
        throw new OrderException("Any instance of payment service is not up..unable to proceed..");
       /* log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Any instance of payment service is not up..unable to proceed..");
        return null;*/
    }

    public OrderResponse paymentServiceRetryFallback(String orderId,Exception exception){
        throw new OrderException("Any instance of payment service is not up..unable to proceed.. all retry are completed");
       /* log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Any instance of payment service is not up..unable to proceed..");
        return null;*/
    }

    public OrderResponse paymentServiceTimeLimiterFallback(String orderId,Exception exception){
        throw new OrderException("Payment Service is not responding withing time  so called fallback..");
       /* log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Any instance of payment service is not up..unable to proceed..");
        return null;*/
    }
    public OrderResponse paymentServiceRateLimiterFallback(String orderId, Exception exception) {
        throw new OrderException("Too may request..");
    }

}
