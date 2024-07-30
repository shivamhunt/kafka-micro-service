package com.inventory_module.orderlistner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderConsumeDTO implements Serializable {

    String orderId;
    ProductOrder product;
}
