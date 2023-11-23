package lesson29.OpenClosed;

public class Main {
    public static void main(String[] args) {
        Celica celica = new Celica();
        workInTaxi(celica);
    }
    static void workInTaxi(Car car){
        car.workInTaxi();
    }
}
