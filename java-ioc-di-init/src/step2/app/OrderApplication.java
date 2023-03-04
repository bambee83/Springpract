package step2.app;


import step2.enums.Menu;
import step2.service.OrderService;

public class OrderApplication implements Consumer {

    private final OrderService orderService;  //final 이라 초기화 필요

    public OrderApplication(OrderService orderService) { // 생성자를 통한 의존성 주입
        this.orderService = orderService;
    } //생성자 주입을 통한 초기화


    @Override
    public void order(Menu menu, int amount) { orderService.saveOrder(menu, amount); }
}
