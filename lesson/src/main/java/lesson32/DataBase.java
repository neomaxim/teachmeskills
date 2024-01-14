package lesson32;

import java.util.Map;

public class DataBase {
    final Map<String, String> UserMap = Map.of(
            "Maxim", "aA12345678",
            "Alex", "aA87654321",
            "Anna", "sS12345678",
            "Artem", "qQ12345678");

    final Map<String, String> getUserMap() {
        return UserMap;
    }
}
