package com.order_module.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PlaceOrderApi {
    @Autowired
    private IPlaceOrderService placeOrderService;
    @PostMapping("/order")
    public void placeOrder(@RequestBody Order order) throws JsonProcessingException {
        log.info("inside the place oder api");
        placeOrderService.getOrder(order);

    }
}
