package com.exchange.challenge;

import java.util.Scanner;

public class MenuDeConversao {

     void exibirMenuDeConversao() {
         ConversorDeMoedas converter = new ConversorDeMoedas();
         Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    \n************* eXchange *****************
                    |  Conversor de moedas                |
                    |  1. Dólar ==> Peso Argentino        |
                    |  2. Peso Argentino ==> Dólar        |
                    |  3. Dólar ==> Real Brasileiro       |
                    |  4. Real Brasileiro ==> Dólar       |
                    |  5. Dólar ==> Peso Colombiano       |
                    |  6. Peso Colombiano => Dólar        |
                    |  7. Sair                            |
                    ****************************************
                    Escolha uma opção:
                    """);
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Saindo...");
                break;
            }

            System.out.println("Digite o valor a ser converitdo: ");
            double valor = scanner.nextDouble();

            String de = "", para = "";

            switch (opcao) {
                    case 1 -> {
                        de = "USD";
                        para = "ARS";
                    }
                    case 2 -> {
                        de = "ARS";
                        para = "USD";
                    }
                    case 3 -> {
                        de = "USD";
                        para = "BRL";
                    }
                    case 4 -> {
                        de = "BRL";
                        para = "USD";
                    }
                    case 5 -> {
                        de = "USD";
                        para = "COP";
                    }
                    case 6 -> {
                        de = "COP";
                        para = "USD";
                    }
                    default -> {
                        System.out.println("Opção inválida.");
                        continue;
                }
            }
            double resultado = converter.converterMoeda(de, para, valor);
            System.out.println("Convertendo " + valor + de + " para " + para);
            System.out.printf("Valor convertido: %.2f %s\n ", resultado, para);
            System.out.print("Deseja continuar? (N) p/ sair (s) p/ continuar: ");
            if (scanner.next().equalsIgnoreCase("n")) {
                System.out.println("Fechando programa...");
                break;
            }
        }
        scanner.close();
    }
}
