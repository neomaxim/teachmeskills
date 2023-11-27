package lesson31.facade;

public class RunCar {
    public static void main(String[] args) {
        CarEngineFacade carStart = new CarEngineFacade();
        carStart.startEngine();
        carStart.stopEngine();


    }


}
