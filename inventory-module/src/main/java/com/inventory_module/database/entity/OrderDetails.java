package com.inventory_module.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ORDER_DETAILS")
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;
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
