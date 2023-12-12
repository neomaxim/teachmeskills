package lesson34;

public class FrontControllerPatternDemo {
    public static void main(String[] args) {

        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME", 321);
        frontController.dispatchRequest("STUDENT", 123);
    }
}
