package step1.app;

import step1.enums.Menu;
import step1.service.ChickenService;
import step1.service.PizzaService;

public class OrderApplication implements Consumer{  //인터페이스, OrderApplication 은 고객의 주문을 받고 service 로 넘겨준다

    private ChickenService chickenService = new ChickenService(); //객체생성/접근제어자!
    private PizzaService pizzaService = new PizzaService(); //실제 로직을 수행하는 곳은 서비스단이라서 서비스를 포함관계로 넣어준다.

    @Override
    public void chickenorder(Menu menu, int amount) {
        chickenService.saveOrder(menu,amount);
    }

    @Override
    public void pizzaorder(Menu menu, int amount) { pizzaService.saveOrder(menu, amount); }
}



