////필드에 직접 주입 : Food 를 Consumer 에 포함 시키고 Food 에 필요한 객체를 주입하여 사용
//public class Consumer {
//
//    Food food;
//
//    void eat() {
//        this.food.eat();
//    }
//
//    public static void main(String[] args) {
//        Consumer consumer = new Consumer();
//        consumer.food = new Chicken();
//        consumer.eat();
//
//        consumer.food = new Tteokbokki();
//        consumer.eat();
//    }
//}
//
//interface Food {
//    void eat();
//}
//
//class Chicken implements Food{
//    @Override
//    public void eat() {
//        System.out.println("치킨을 먹는다.");
//    }
//}
//
//class Tteokbokki implements Food{
//    @Override
//    public void eat() {
//        System.out.println("떡볶이를 먹는다.");
//    }
//}
//


//메서드를 통한 주입 : set 메서드를 사용하여 필요한 객체를 주입하여 사용
//public class Consumer {
//
//    Food food;
//
//    void eat() {
//        this.food.eat();
//    }
//
//    public void setFood(Food food) {
//        this.food = food;
//    }
//
//    public static void main(String[] args) {
//        Consumer consumer = new Consumer();
//        consumer.setFood(new Chicken());
//        consumer.eat();
//
//        consumer.setFood(new Tteokbokki());
//        consumer.eat();
//    }
//}
//
//interface Food {
//    void eat();
//}
//
//class Chicken implements Food{
//    @Override
//    public void eat() {
//        System.out.println("치킨을 먹는다.");
//    }
//}
//
//class Tteokbokki implements Food{
//    @Override
//    public void eat() {
//        System.out.println("떡볶이를 먹는다.");
//    }
//}


//생성자를 통한 주입 : 생성자를 사용하여 필요한 객체를 주입하여 사용
public class Consumer {

    Food food;

    public Consumer(Food food) {
        this.food = food;
    }

    void eat() {
        this.food.eat();
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer(new Chicken());
        consumer.eat();

        consumer = new Consumer(new Tteokbokki());
        consumer.eat();
    }
}

interface Food {
    void eat();
}

class Chicken implements Food{
    @Override
    public void eat() {
        System.out.println("치킨을 먹는다.");
    }
}

class Tteokbokki implements Food{
    @Override
    public void eat() {
        System.out.println("떡볶이를 먹는다.");
    }
}