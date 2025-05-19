package com.exchange.challenge;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchange {
    private static  final String URL_API = "https://v6.exchangerate-api.com/v6/b543277326d77d4facb68e4b/latest/";

    private final HttpClient client;
    private final Gson gson;

    public ApiExchange() {
        client = HttpClient.newHttpClient();
        gson = new Gson();
    }
    public double obterTaxaCambio(String de, String para) throws IOException, InterruptedException {
        String url = URL_API + de;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse
                .BodyHandlers
                .ofString());

        TaxaDeCambio resultado = gson.fromJson(response.body(), TaxaDeCambio.class);
        Double taxa = resultado.conversion_rates.get(para);

        if (taxa == null) {
            throw new RuntimeException("Moeda inválida ou não encontrada: " + para);
        }
        return taxa;
    }
}
