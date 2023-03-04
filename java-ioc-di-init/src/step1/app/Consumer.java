package step1.app;

import step1.enums.Menu;

public interface Consumer {  //고객은 주문하는 기능 하나만 가지고 있다

    void chickenorder(Menu menu, int amount); //추상매서드선언, 파라미터로 메뉴와 이름을 준다
    void pizzaorder(Menu menu, int amount);


}
