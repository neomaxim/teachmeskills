package lesson21.hw1.util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtil {
    public static Map<String, String> parseUriQuariUri(String quaryParam) {
        return Arrays.stream(quaryParam.split("&"))
                .map(str -> str.split("="))
                .collect(Collectors.toMap(it -> it[0], it -> it[1], (a, b) -> b));

    }
}
