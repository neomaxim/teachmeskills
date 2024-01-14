package lesson31.decorator;

public class CpuOverclocking extends OptionDecorator {
    public CpuOverclocking(ServiceComputer service) {
        super(service, 20, "Stage_1");
    }
}
