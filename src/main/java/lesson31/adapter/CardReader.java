package lesson31.adapter;

public class CardReader implements Usb {
    private MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsb() {
        this.memoryCard.insert();
    }
}
