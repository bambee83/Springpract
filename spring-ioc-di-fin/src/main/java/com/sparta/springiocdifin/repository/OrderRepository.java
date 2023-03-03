package com.sparta.springiocdifin.repository;


import com.sparta.springiocdifin.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByFoodName(String foodName);
}

