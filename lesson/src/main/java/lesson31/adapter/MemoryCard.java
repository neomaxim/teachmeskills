package lesson31.adapter;

public class MemoryCard extends WorkUsb {
    public void insert() {
        System.out.println("Карта памяти успешно вставлена в картридер!");
    }

    @Override
    public void copyData() {
        System.out.println("MemoryCard");

        super.copyData();

    }
}
