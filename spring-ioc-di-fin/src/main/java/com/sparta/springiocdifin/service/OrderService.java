package com.sparta.springiocdifin.service;

import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;

import java.util.List;

public interface OrderService {  //주문 기능
    void order(Menu menu, int amount); // 메서드 호출
    List<Order> getOrders(Menu menu); //주문을 가져오는 기능 (import)
}
