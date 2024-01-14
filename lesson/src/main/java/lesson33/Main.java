package lesson33;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Max", "123");
        User user2 = new User(1, "Max", "123");

        boolean isHashcodeEquals = user1.hashCode() == user2.hashCode();
        System.out.println(user1.hashCode() + " " + user2.hashCode());

        if (isHashcodeEquals) {
            System.out.println("индификаторы  идентичны ,cледует сравнить методом equals." + "результат " + user1.equals(user2));


        } else {
            System.out.println("Не следует сравнивать методом equals, т.к. " +
                    "идентификатор отличается, что означает, что объекты точно не равны.");
        }
        System.out.println(user1.toString() + " " + user2.toString());
    }
}
