package com.sparta.springiocdifin.service;

import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;
import com.sparta.springiocdifin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("pizza")
public class PizzaService implements OrderService {

    private final OrderRepository orderRepository;
    private String type;

    @Autowired
    public PizzaService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void order(Menu menu, int amount) {
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);
        this.orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders(Menu menu) {

        List<Order> allByFoodName = orderRepository.findAllByFoodName(menu.getFoodName());

        return allByFoodName;    }
}
