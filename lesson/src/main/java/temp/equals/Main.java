package temp.equals;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Andrew", 250);
        User user2 = new User("Andrew", 250);
        //Сравниваем два объекта и выводим результат
        boolean bool = user1.equals(user2);
        System.out.println(bool);








        System.out.println(
                new EqualsAndHashCodeExample.Simpson("Homer", 35, 120).equals(
                        new EqualsAndHashCodeExample.Simpson("Homer", 35, 120)));
    }


}
