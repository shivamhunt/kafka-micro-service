package com.order_module.order;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IPlaceOrderService {
    public void getOrder(Order order) throws JsonProcessingException;
}
