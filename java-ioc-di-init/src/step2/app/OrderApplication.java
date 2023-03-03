package step2.app;


import step2.enums.Menu;
import step2.service.ChickenService;
import step2.service.PizzaService;

public class OrderApplication implements Consumer {

    private final ChickenService chickenService  = new ChickenService();
    private final PizzaService pizzaService  = new PizzaService();

    @Override
    public void chickenOrder(Menu menu, int amount) {
        chickenService.saveOrder(menu, amount);
    }

    @Override
    public void pizzaOrder(Menu menu, int amount) {
        pizzaService.saveOrder(menu, amount);
    }
}
