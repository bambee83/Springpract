package com.sparta.springiocdifin.service;


import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;
import com.sparta.springiocdifin.repository.InventoryRepository;
import com.sparta.springiocdifin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //bean 으로 등록
@Primary
public class ChickenService implements OrderService { //구현체

    private final OrderRepository orderRepository;   //orderrepository 받아오기
    private final InventoryRepository inventoryRepository;

    @Autowired // 생성자를 통한 주입
    public ChickenService(OrderRepository orderRepository, InventoryRepository inventoryRepository) {
        this.orderRepository = orderRepository;
        // 다른 테이블도 추가로 연결해야할 경우
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void order(Menu menu, int amount) {
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);  //주문 하나와 매칭이 되는 order 인스턴스
        this.orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders(Menu menu) {

        List<Order> allByFoodName = orderRepository.findAllByFoodName(menu.getFoodName()); //기본메소드에 없는거 > repository 에 만들어주기
        for (Order order : allByFoodName) {
            order.setPriceAmount();
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount()); // 확인을 위한 출력 > 추후 지워주는 것이 좋다.
        }

        return allByFoodName;
    }
}
