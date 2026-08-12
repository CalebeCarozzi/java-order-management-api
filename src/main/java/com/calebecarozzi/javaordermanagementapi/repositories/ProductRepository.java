package com.calebecarozzi.javaordermanagementapi.repositories;

import com.calebecarozzi.javaordermanagementapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
