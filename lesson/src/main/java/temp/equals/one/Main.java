package temp.equals.one;

public class Main {
    public static void main(String[] args) {
        Man man1 = new Man(123);
        Man man2 = new Man(123);
        System.out.println(man1.hashCode());
        System.out.println(man2.hashCode());
        System.out.println(man1.equals(man2));
    }
}
