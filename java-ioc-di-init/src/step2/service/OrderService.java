package step2.service;

import step2.enums.Menu;

public interface OrderService {
    void saveOrder(Menu menu, int amount); //구현체를 생각해서 공통 기능을 선언 , 매개변수는 menu 와 amount
}
