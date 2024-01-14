package lesson30.Loner;

public class Main {
    public static void main(String[] args) {
        FirstAndUnchangeable one = FirstAndUnchangeable.getInstance("курица");
        FirstAndUnchangeable two = FirstAndUnchangeable.getInstance("яйцо");
        System.out.println(one.value);
        System.out.println(two.value);
    }
}
