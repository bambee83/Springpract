package step2.service;


import step2.enums.Menu;
import step2.order.Order;
import step2.order.OrderList;

public class ChickenService implements OrderService {  //orderservice 의 구현체

    private final OrderList orderList;

    public ChickenService(OrderList orderList) {
        this.orderList = orderList;
    }  // 생성자주입을 통한 초기화

    @Override
    public void saveOrder(Menu menu, int amount) {
        System.out.println("치킨 주문 저장");
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount);
         orderList.setOrderList(order);
    }


}
