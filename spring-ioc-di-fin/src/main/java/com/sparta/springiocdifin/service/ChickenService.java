package com.sparta.springiocdifin.service;


import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;
import com.sparta.springiocdifin.repository.InventoryRepository;
import com.sparta.springiocdifin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ChickenService implements OrderService {

    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public ChickenService(OrderRepository orderRepository, InventoryRepository inventoryRepository) {
        this.orderRepository = orderRepository;
        // 다른 테이블도 추가로 연결해야할 경우
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void order(Menu menu, int amount) {
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);
        this.orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders(Menu menu) {

        List<Order> allByFoodName = orderRepository.findAllByFoodName(menu.getFoodName());
        for (Order order : allByFoodName) {
            order.setPriceAmount();
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }

        return allByFoodName;
    }
}
