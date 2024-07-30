package com.order_module.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlaceOrderService implements  IPlaceOrderService{

    @Autowired
     KafkaTemplate<String,String> kafkaTemplate;

    final String TOPIC="order-topic";
    @Override
    public void getOrder(Order order) throws JsonProcessingException {
    log.info("inside the place order service");
        ObjectMapper om= new ObjectMapper();
        String orderString= om.writeValueAsString(order);
        kafkaTemplate.send(TOPIC,orderString);
    log.info("order sent to the kafka");
    }
}
