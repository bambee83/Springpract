package step2.app;

import step2.enums.Menu;

public interface Consumer {
    void chickenOrder(Menu menu, int amount);
    void pizzaOrder(Menu menu, int amount);
}
