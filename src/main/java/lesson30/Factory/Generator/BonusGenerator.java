package lesson30.Factory.Generator;

import lesson30.Factory.Model.Bonus;
import lesson30.Factory.Model.GameItem;

public class BonusGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new Bonus();
    }
}
