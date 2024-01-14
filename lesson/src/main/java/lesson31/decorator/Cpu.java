package lesson31.decorator;


public class Cpu implements ServiceComputer {
    private String cpu;
    private Integer perfomance;

    public Cpu(String upgrate, Integer perfomance) {
        cpu = upgrate;
        this.perfomance = perfomance;
    }

    @Override
    public String getUpgrate() {
        return this.cpu;
    }

    @Override
    public Integer getPerfomance() {
        return this.perfomance;
    }
}
