package com.sparta.springiocdifin.service;

import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;

import java.util.List;

public interface OrderService {
    void order(Menu menu, int amount);
    List<Order> getOrders(Menu menu);
}
