package temp.equals.oneL;

public class Man {

    public static void main(String[] args) {

       Equals man1 = new Equals();
        man1.dnaCode = "111122223333";

        Equals man2 = new Equals();
        man2.dnaCode = "111122223333";

        System.out.println(man1.equals(man2));
    }
}
