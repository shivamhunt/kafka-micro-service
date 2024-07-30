package com.inventory_module.database.repository;

import com.inventory_module.database.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetails,Long> {
}
