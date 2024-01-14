package lesson31.adapter;

public class Main {
    public static void main(String[] args) {
        Usb cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsb();
        MemoryCard memoryCard = new MemoryCard();
        memoryCard.copyData();
        UsbFlash usbFlash = new UsbFlash();
        usbFlash.copyData();




    }
}
