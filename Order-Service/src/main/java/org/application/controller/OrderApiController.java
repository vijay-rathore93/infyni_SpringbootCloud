package org.application.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.application.service.impl.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.vijayCode.api.OrderApi;
import org.vijayCode.model.OrderResponse;
import org.vijayCode.model.SuccessResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderApiController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<SuccessResponse> createOrder(OrderResponse orderResponse) {
        return new ResponseEntity<>(orderService.createOrder(orderResponse),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<SuccessResponse>> deleteOrder(UUID orderId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderResponse> getOrder(String orderId) {
        return new ResponseEntity<>(orderService.getOrder(orderId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SuccessResponse>> updateOrder(@ApiParam(value = "", required = true) @RequestHeader(value = "orderId", required = true) UUID orderId, @ApiParam(value = "To be Update Order Info", required = true) @Valid @RequestBody OrderResponse orderResponse) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
