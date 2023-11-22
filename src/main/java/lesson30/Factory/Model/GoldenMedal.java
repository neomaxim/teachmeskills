package lesson30.Factory.Model;

import lesson30.Factory.Model.GameItem;

public class GoldenMedal implements GameItem {
    @Override
    public void open() {
        System.out.println("Получение золотой медали");
    }
}
