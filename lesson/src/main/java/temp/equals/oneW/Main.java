package temp.equals.oneW;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Maxim");
        User user2 = new User("Maxim");
        User user3 = new User("Maxim");

        boolean bool = user1.equals(user2);
        System.out.println(bool);
    }
}
