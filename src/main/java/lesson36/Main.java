package lesson36;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<String> cars = List.of("Nissan", "Mazda", "Nissan", "Bmw", "Mercedes", "Opel", "Bmw");
        System.out.println(cars);
        Map<String, Boolean> map = cars.stream()
                .collect(Collectors.toMap(i -> i, i -> false, (oldValue, newValue) -> true));
        System.out.println(map);

        Map<String, String> map1 = cars.stream()
                .collect(Collectors.toMap(i -> String.valueOf(i.charAt(0)), i -> String.valueOf(i.charAt(i.length() - 1)), (oldValue, newValue) -> oldValue));
        System.out.println(map1);
    }

}
