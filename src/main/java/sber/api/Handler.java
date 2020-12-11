package sber.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Handler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "This is the response";
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()){
            os.write(response.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
