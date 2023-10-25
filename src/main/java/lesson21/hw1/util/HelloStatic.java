package lesson21.hw1.util;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Objects;

public class HelloStatic implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI reguestURI = exchange.getRequestURI();
        System.out.println(reguestURI.getPath());
        if (Objects.equals(reguestURI.getPath(), "/static/index.html")) {
            File file = new File("C:\\java\\C24New\\teach\\src\\main\\java\\lesson21\\hw1\\index.html");
            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, file.length());
            try (OutputStream os = exchange.getResponseBody();
                 FileInputStream fis = new FileInputStream(file)) {
                int count;
                byte[] buffer = new byte[1024];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                }

            }

        } else {
            String response = "File not found";
            exchange.sendResponseHeaders(404, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}

