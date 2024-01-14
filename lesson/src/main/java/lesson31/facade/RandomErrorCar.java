package lesson31.facade;

import java.util.Random;

public class RandomErrorCar {
    static Random random = new Random();
    static int rand = random.nextInt(10) * 3;
}
