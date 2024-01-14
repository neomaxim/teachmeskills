package lesson31.decorator;

public class RunUpgrate {

    public static void main(String[] args) {
        Integer maxPerfomance;
        ServiceComputer cpu = new Cpu("INTEL", 15);
        ServiceComputer videoCard = new VideoCard("NVIDIA", 35);
        ServiceComputer overClockCpu = new CpuOverclocking(cpu);
        maxPerfomance = cpu.getPerfomance() + videoCard.getPerfomance() + overClockCpu.getPerfomance();
        System.out.println(maxPerfomance + " производительность " + cpu.getUpgrate() + " + " + videoCard.getUpgrate() + " " + overClockCpu.getUpgrate());

        ServiceComputer overClockVideCard = new VideoCardOverclocking(videoCard, 55);
        maxPerfomance = overClockVideCard.getPerfomance();
        System.out.println(maxPerfomance);
    }
}
