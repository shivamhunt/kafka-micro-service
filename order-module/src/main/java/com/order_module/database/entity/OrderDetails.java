package com.order_module.database.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    int id;
    @Column(name="ORDER_ID")
    String orderId;
    @Column(name = "ORDER_TIME")
    Date orderTime;
    @Column(name = "PRODUCT_ID")
    String productId;
    @Column(name = "PRODUCT_COUNT")
    int productCount;
    @Column(name = "AMOUNT")
    int orderValue;

}
