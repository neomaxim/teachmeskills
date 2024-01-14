package lesson31.adapter;

public class UsbFlash extends WorkUsb{
    @Override
    public void copyData() {
        System.out.println("UsbFlash");
        super.copyData();

    }
}
