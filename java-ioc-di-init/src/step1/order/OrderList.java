package step1.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderList {  //데이터베이스로 사용하는 클래스

    private String foodName;

    public OrderList(String foodName) {
        this.foodName = foodName;
    }

    private static List<Order> orderList = new ArrayList<>(); // Static 변수는 인스턴스 생성하지 않아도 사용 가능 ! ,
                                                                // 해당 리스트에는 <오더> 타입만 들어갈 수 있다!

    public void setOrderList(Order order) { //setter 역할 !,
        orderList.add(order); // 받아온 Order 를 넣어준다
    }

    public List<Order> getOrderList() { //주문을 가져올 매서드
         if (foodName.equals("치킨")) {
             return orderList.stream().filter(f -> f.getFoodName().equals("치킨")).collect(Collectors.toList());
         } else if (foodName.equals("피자")) {
             return orderList.stream().filter(f ->f.getFoodName().equals("피자")).collect(Collectors.toList());
         } else { //스트림
             return orderList;
         }
    }  //주문을 받아오는 매서드행

}
