package lesson29.singleRespons;

public class Cook implements Emplyee{
    @Override
    public int gerSalary() {
        return 0;
    }

    void cook() {
        System.out.println("Cook.");
    }
}