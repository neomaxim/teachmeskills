package lesson29.singleRespons;

public class EmplyeeFacade {
    Cook cook = new Cook();
    Janitor janitor = new Janitor();

    void Cook() {
        cook.cook();
    }

    void cleanFood() {
        janitor.cleanFood();
    }
}
