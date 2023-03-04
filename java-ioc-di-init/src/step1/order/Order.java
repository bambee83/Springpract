package step1.order;

public class Order { //주문을 받아서 OrderList 에 매칭해주는 클래스
    private String foodName;
    private int price;
    private int amount;  //해당하는 필드생성

    public Order(String foodName, int price, int amount) { //생성자를 통한 초기화
        this.foodName = foodName;
        this.price = price;
        this.amount = amount;
    }

    public String getFoodName() {
        return foodName;
    } // private 제어자이기 때문에 getter 메소드

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
