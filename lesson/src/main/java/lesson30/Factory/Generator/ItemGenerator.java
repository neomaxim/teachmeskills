package lesson30.Factory.Generator;

import lesson30.Factory.Model.GameItem;

public abstract class ItemGenerator {
    public void openReward() {

        GameItem gameItem = createItem();
        gameItem.open();
    }


    public abstract GameItem createItem();

}
