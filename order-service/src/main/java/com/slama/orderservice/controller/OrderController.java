package com.slama.orderservice.controller;

import com.slama.orderservice.dto.OrderRequest;
import com.slama.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public record OrderController(
        OrderService orderService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
        log.info("Order created");
    }
}
