package lesson22.hw1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WorldHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Integer cityTime = null;
        URI reguestURI = exchange.getRequestURI();
        System.out.println(reguestURI.toString());
        try (OutputStream responseBody = exchange.getResponseBody()) {
            LocalTime nowTime = LocalTime.now();
            Map<String, Integer> cityMap = new HashMap<>();
            cityMap.put("/minsk", +0);
            cityMap.put("/washington", -4);
            cityMap.put("/beijing", +8);
            for (Map.Entry<String, Integer> entry : cityMap.entrySet())
                if (Objects.equals(reguestURI.toString(), entry.getKey())) {
                    cityTime = entry.getValue();
                }
            String text = "time, %s!".formatted(Objects.toString(nowTime.plusHours(cityTime)));
            exchange.sendResponseHeaders(200, text.getBytes().length);
            responseBody.write(text.getBytes());
        }

    }
}
