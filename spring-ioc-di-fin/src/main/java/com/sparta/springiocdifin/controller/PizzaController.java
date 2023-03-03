package com.sparta.springiocdifin.controller;


import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;
import com.sparta.springiocdifin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final OrderService orderservice;

    @Autowired
    public PizzaController(@Qualifier("pizza") OrderService orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping("/saveOrder/{amount}")
    public void saveOrder(@PathVariable int amount) {
        this.orderservice.order(Menu.Pizza, amount);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return this.orderservice.getOrders(Menu.Pizza);
    }
}
