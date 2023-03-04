package com.sparta.springiocdifin.controller;


import com.sparta.springiocdifin.entity.Order;
import com.sparta.springiocdifin.enums.Menu;
import com.sparta.springiocdifin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //클래스를 입구, 출구의 역할로 @Controller  +  bean 을 만들어준다 !
@RequestMapping("/chicken") // 구분용도임 pizza 랑.... 하단 url 앞에 전체적용됨 !!
public class  ChickenController {

    private final OrderService orderservice; //각각의 레이어는 “일반적으로” 자기와 인접한 레이어와 직접 소통합니다,
    // 이 경우 ContentService 객체를 가지고 있어, 컨트롤러 단에서 서비스 단으로 새로 받아온 데이터를 전달하거나 서비스 로직을 호출 할 수 있습니다.

    @Autowired // 인젝터(외부클래스)를 자동으로 찾아서 주입하는 기능
    public ChickenController(OrderService orderservice) {
        this.orderservice = orderservice;
    } //생성자주입

    @PostMapping("/saveOrder/{amount}")
    public void saveOrder(@PathVariable int amount) {
        this.orderservice.order(Menu.Chicken, amount);
    }

    @GetMapping("/getOrders") //가져오자 !
    public List<Order> getOrders() {
        return orderservice.getOrders(Menu.Chicken);
    } //반환타입이 List<Order> 이다
    // List<Order> orderList = orderService.getOrders(Menu.Chicken); 이랑 같은 의미이다.
}

// bean 과 ioc container 기능들을 사용해서 해결해준다
// > @ 붙은 것들 찾아서 추적을 통해 bean 타입으로 생성 후 container 에 보관 > 필요한 곳에 주입()@Autowired(하나만 있을 때는 생략 가능)
// 클래스를 만들지 않아도 스프링이 자동으로 생성해서 관리하는 객체가 bean 이다 , @ > bean 으로 등록
// 자바에서는 클래스 사용 전 new 를 사용해서 인스턴스를 생성해야 함

// 1. Bean 이란 스프링이 관리하는 클래스다
// 2. @Autowired 란 주입해달라고 스프링에게 알려주는 애노테이션이다
// 3. @Autowired 를 통해 주입할 수 있는 객체는 꼭 bean 이어야 한다.
