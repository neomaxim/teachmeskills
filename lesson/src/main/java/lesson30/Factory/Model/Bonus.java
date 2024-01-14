package lesson30.Factory.Model;

public class Bonus implements GameItem {
    @Override
    public void open() {
        System.out.println("Начисление бонусов");
    }
}
