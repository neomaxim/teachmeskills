package lesson31.decorator;

public class VideoCardOverclocking extends OptionDecorator {
    public VideoCardOverclocking(ServiceComputer service, Integer perfomance) {
        super(service, perfomance, service.getUpgrate());
    }

}
