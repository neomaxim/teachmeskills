package lesson31.facade;

public class FuelInjector {


    void on() {
        System.out.println("Включение бензанасоса");

    }

    void inject() {
        if (RandomErrorCar.rand >= 10) {
            System.out.println("давление создаваемое насосом достаточно для подачи в форсунки");
        } else {
            System.out.println(RandomErrorCar.rand);
            System.out.println("Ошибка!!! низкое давление в топливной рампе");
            System.exit(0);
        }

    }

    void off() {
        System.out.println("Отключение бензонасоса");

    }


}
