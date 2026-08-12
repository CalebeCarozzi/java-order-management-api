package com.calebecarozzi.javaordermanagementapi.repositories;

import com.calebecarozzi.javaordermanagementapi.entities.Category;
import com.calebecarozzi.javaordermanagementapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
