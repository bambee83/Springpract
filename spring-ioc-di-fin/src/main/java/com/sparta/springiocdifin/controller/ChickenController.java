package com.sparta.springiocdifin.controller;


import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;
import com.sparta.springiocdifin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chicken")
public class  ChickenController {

    private final OrderService orderservice;

    @Autowired
    public ChickenController(OrderService orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping("/saveOrder/{amount}")
    public void saveOrder(@PathVariable int amount) {
        this.orderservice.order(Menu.Chicken, amount);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return orderservice.getOrders(Menu.Chicken);
    }
}
