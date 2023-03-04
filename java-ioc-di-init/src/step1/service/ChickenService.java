package step1.service;


import step1.enums.Menu;
import step1.order.Order;
import step1.order.OrderList;

public class ChickenService {  //서비스단 핵심로직수행

    private final OrderList orderList = new OrderList("치킨");  //Order list 를 사용하기 위한 인스턴스생성

    public void saveOrder(Menu menu, int amount) {  //치킨저장메소드
        Order order = new Order(menu.getFoodName(), menu.getPrice(), amount); //순서 중요하다 !! (생성자를 통한 초기화)
        orderList.setOrderList(order); //메소드
        // 주문 하나를 order class 객체로 만들어서 그 order 를 데이터베이스 대용인 orderList 안의 list 에 넣어준다
    }
}
