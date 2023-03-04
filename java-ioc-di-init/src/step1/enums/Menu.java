package step1.enums;

public enum Menu {  //enum 타입으로 관리 , 메뉴생성 !
    chicken("치킨", 30000),
    pizza("피자", 50000);

    private String foodName; // 변수선언 (파라미터로 값을 넣어준다!)
    private int price;

    Menu(String foodName, int price) { //생성자
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() { //getter
        return foodName;
    } // getter (private 제어자)

    public int getPrice() { //getter
        return price;
    }
}
