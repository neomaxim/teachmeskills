package lesson31.decorator;

public class OptionDecorator implements ServiceComputer {
    private ServiceComputer service;
    private Integer perfomance;
    private String upgrade;

    public OptionDecorator(ServiceComputer service, Integer perfomance, String upgrade) {
        this.service = service;
        this.perfomance = perfomance;
        this.upgrade = upgrade;
    }

    @Override
    public String getUpgrate() {
        return this.upgrade + service.getUpgrate();
    }

    @Override
    public Integer getPerfomance() {
        return this.perfomance + service.getPerfomance();
    }
}
