package lesson31.facade;

public class Battery {
    private static int MIN_VOLTAGE = 10;

    void test() {
        if (RandomErrorCar.rand >= MIN_VOLTAGE) {
            System.out.println("аккамулятор в состоянии завести двигатель, ваш заряд составляет более " + MIN_VOLTAGE);
        } else {
            System.out.println("Ваш аккамулятор не сможет завести автомобиль, выш заряд составляет меньше " + MIN_VOLTAGE);
            System.exit(0);
        }
    }

}
