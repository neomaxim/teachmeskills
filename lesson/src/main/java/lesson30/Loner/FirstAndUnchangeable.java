package lesson30.Loner;

import java.util.Objects;

public class FirstAndUnchangeable {
    private static FirstAndUnchangeable INSTANCE;
    public String value;
    private FirstAndUnchangeable(String value) {
        this.value = value;
    }
    public static FirstAndUnchangeable getInstance(String value){
        if(INSTANCE == null){
            INSTANCE = new FirstAndUnchangeable(value);
            System.out.println("Это сообщение : %s! будет единственным".formatted(Objects.toString(value,"пусто")));

        }
        return INSTANCE;
    }
}
