package lesson30.Factory;

import lesson30.Factory.Generator.BonusGenerator;
import lesson30.Factory.Generator.GoldGenerator;
import lesson30.Factory.Generator.ItemGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameRun {
    public static void main(String[] args) {
        Random random = ThreadLocalRandom.current();
        List<ItemGenerator> generatorList = new ArrayList<>();
        generatorList.add(new BonusGenerator());
        generatorList.add(new GoldGenerator());

        for (int i = 0; i < 10; i ++){
            int rand = Math.abs(random.nextInt() % 2) == 0 ? 0 : 1;
            ItemGenerator itemGenerator = generatorList.get(rand);
            itemGenerator.openReward();
        }
    }
}
