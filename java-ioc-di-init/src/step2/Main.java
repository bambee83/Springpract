package step2;


import step2.app.Consumer;
import step2.app.OrderApplication;
import step2.enums.Menu;
import step2.order.Order;
import step2.order.OrderList;

public class Main {
    public static void main(String[] args) {

        // 주문
        Consumer consumer;

        consumer = new OrderApplication();
        consumer.chickenOrder(Menu.Chicken, 2);

        // 주문 내역 확인
        OrderList orderList = new OrderList("치킨");
        for (Order order : orderList.getOrderList()) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
            System.out.println();
        }

        consumer.pizzaOrder(Menu.Pizza, 2);

        // 주문 내역 확인
        orderList = new OrderList("피자");
        for (Order order : orderList.getOrderList()) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }

    }
}
