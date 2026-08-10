package com.calebecarozzi.javaordermanagementapi.repositories;

import com.calebecarozzi.javaordermanagementapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
