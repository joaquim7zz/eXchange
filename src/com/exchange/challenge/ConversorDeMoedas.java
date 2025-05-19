package com.exchange.challenge;

public class ConversorDeMoedas {
    private final ApiExchange apiExchange = new ApiExchange();

    public double converterMoeda(String de, String para, double valor) {
        try {
            double taxa = apiExchange.obterTaxaCambio(de, para);
            return valor * taxa;
        } catch (Exception e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
            return 0;
        }
    }
}
