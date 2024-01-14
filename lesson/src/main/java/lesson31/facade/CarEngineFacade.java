package lesson31.facade;

public class CarEngineFacade {

    private Battery battery = new Battery();
    private FuelInjector fuelInjector = new FuelInjector();
    private Starter starter = new Starter();


    public void startEngine() {
        battery.test();

        fuelInjector.on();

        fuelInjector.inject();
        starter.start();

    }

    public void stopEngine() {
        fuelInjector.off();
        starter.stop();
    }
}