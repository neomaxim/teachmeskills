package lesson30.Factory.Generator;

import lesson30.Factory.Model.GameItem;
import lesson30.Factory.Model.GoldenMedal;

public class GoldGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new GoldenMedal();
    }
}
