package lesson21.hw1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lesson21.hw1.util.HttpUtil;


import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

public class HelloWorldHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI reguestURI = exchange.getRequestURI();
        System.out.println(reguestURI.getQuery());
        String quaryParam = reguestURI.getQuery();
        Map<String, String> resultMap = quaryParam == null || quaryParam.isEmpty() ? HttpUtil.parseUriQuariUri("name=USER") : HttpUtil.parseUriQuariUri(quaryParam);

        try (OutputStream responseBody = exchange.getResponseBody()) {
            String name = resultMap.get("name");
            String text = "Hello, %s!".formatted(Objects.toString(name, "No name"));
            exchange.sendResponseHeaders(200, text.getBytes().length);
            responseBody.write(text.getBytes());
        }

    }
}
