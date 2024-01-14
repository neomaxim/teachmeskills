package lesson31.decorator;

public class VideoCard implements ServiceComputer {
    private String videoCard;
    private Integer perfomance;


    public VideoCard(String videoCard, Integer perfomance) {
        this.videoCard = videoCard;
        this.perfomance = perfomance;
    }

    @Override
    public String getUpgrate() {
        return this.videoCard;
    }

    @Override
    public Integer getPerfomance() {
        return this.perfomance;
    }
}
