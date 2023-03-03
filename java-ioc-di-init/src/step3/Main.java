package step3;

import step3.app.Consumer;
import step3.app.OrderApplication;
import step3.enums.Menu;
import step3.order.Order;
import step3.order.OrderList;
import step3.service.ChickenService;
import step3.service.OrderService;
import step3.service.PizzaService;

public class Main {
    public static void main(String[] args) {

        // 주문
        Consumer consumer;
        OrderService orderService;

        orderService = new ChickenService(new OrderList("치킨", "Robbie", "1234"));
        consumer = new OrderApplication(orderService);
        consumer.order(Menu.Chicken, 2);

        // 주문 내역 확인
        OrderList orderList = new OrderList("치킨", "Robbie", "1234");
        for (Order order : orderList.getOrderList()) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
            System.out.println();
        }

        orderService = new PizzaService(new OrderList("피자", "Robbie", "1234"));
        consumer = new OrderApplication(orderService);
        consumer.order(Menu.Pizza, 2);

        // 주문 내역 확인
        orderList = new OrderList("피자", "Robbie", "1234");
        for (Order order : orderList.getOrderList()) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }

    }
}
