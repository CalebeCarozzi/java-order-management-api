package com.calebecarozzi.javaordermanagementapi.repositories;

import com.calebecarozzi.javaordermanagementapi.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
