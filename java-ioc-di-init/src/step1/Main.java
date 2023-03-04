package step1;


import step1.app.Consumer;
import step1.app.OrderApplication;
import step1.enums.Menu;
import step1.order.Order;
import step1.order.OrderList;

public class Main { //고객이 실제로 주문하는 공간
    public static void main(String[] args) {
        Consumer consumer; // 인터페이스

        //치킨 주문
        consumer = new OrderApplication(); // 어플리케이션을 실행할 구현체
        consumer.chickenorder(Menu.chicken, 1);

        //주문 확인
        OrderList orderList = new OrderList("치킨");
        for (Order order : orderList.getOrderList()) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }


        //피자 주문
        consumer.pizzaorder(Menu.pizza, 3);

        //주문 확인
        orderList = new OrderList("피자");
        for (Order order : orderList.getOrderList()) {
            System.out.println(order.getFoodName());
            System.out.println(order.getPrice());
            System.out.println(order.getAmount());
        }
    }
}
