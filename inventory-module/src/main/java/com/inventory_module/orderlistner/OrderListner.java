package com.inventory_module.orderlistner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory_module.database.entity.OrderDetails;
import com.inventory_module.database.repository.OrderDetailRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class OrderListner {
    @Autowired
     OrderDetailRepo orderDetailRepo;
    final String TOPIC = "order-topic";
    final String GROUP_ID = "order-group";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void updateInventory(String orderString) throws JsonProcessingException, InterruptedException {
        log.info("order listening");
        log.info("order {}", orderString);
        ObjectMapper om = new ObjectMapper();
        Thread.sleep(2000);
        OrderConsumeDTO order = om.readValue(orderString, OrderConsumeDTO.class);
        OrderDetails od = new OrderDetails();
        UUID uuid = UUID.randomUUID();
        String ordersId = String.valueOf((uuid.getMostSignificantBits() & Long.MAX_VALUE));
        od.setOrderId(ordersId);
        Date date = new Date();
        od.setOrderTime(date);
        ProductOrder product = order.getProduct();
        int productQuantity = product.getProductQuantity();
        int productId = product.getProductId();
        od.setOrderValue(productQuantity * 10);
        od.setProductId(String.valueOf(productId));
        od.setProductCount(productQuantity);

        orderDetailRepo.save(od);
        log.info("order listening completed");

    }
}
