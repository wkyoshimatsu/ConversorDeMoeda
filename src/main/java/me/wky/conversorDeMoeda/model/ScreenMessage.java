package me.wky.conversorDeMoeda.model;

import java.util.Map;

public class ScreenMessage {

    private static final Map<String, String> STANDARD_CURRENCIES = Map.of(
            "BRL", "Real (BRL)            ",
            "USD", "Dólar Americano (USD) ",
            "ARS", "Peso Argentino (ARS)  ",
            "JPY", "Iene Japonês (JPY)    ");

    private static final String[][] STANDARD_EXCHANGE_OPTIONS = {
            {"BRL","USD"},
            {"USD","BRL"},
            {"BRL","ARS"},
            {"ARS","BRL"},
            {"BRL","JPY"},
            {"JPY","BRL"}
    };

    private static final int EXCHANGE_OPTIONS_SIZE = STANDARD_EXCHANGE_OPTIONS.length;

    public static final int CUSTOM_OPTION = EXCHANGE_OPTIONS_SIZE + 1;

    public static final int EXIT_OPTION = EXCHANGE_OPTIONS_SIZE + 2;

    public static void printExchangeOptions(){
        System.out.println("""
                ***************************************************
                      Seja bem-vindo(a) ao Conversor de Moeda
                """);

        for (int i = 0; i < Currency.EXCHANGE_OPTIONS_SIZE + 2; i++) {
            int index = i + 1;
            if (index == CUSTOM_OPTION){
                System.out.println(index + ") Opção customizada");
            } else if (index == EXIT_OPTION){
                System.out.println(index + ") Sair");
            } else {
                System.out.printf("%d) %s -> %s\n",
                        index,
                        Currency.STANDARD_CURRENCIES.get(Currency.STANDARD_EXCHANGE_OPTIONS[i][0]),
                        Currency.STANDARD_CURRENCIES.get(Currency.STANDARD_EXCHANGE_OPTIONS[i][1]));
            }
        }

        System.out.println("""
                
                Selecione uma opção válida:
                ***************************************************""");

    }

    public static String getBaseCurrency(int option){
        return STANDARD_EXCHANGE_OPTIONS[option - 1][0];
    }

    public static String getTargetCurrency(int option){
        return STANDARD_EXCHANGE_OPTIONS[option - 1][1];
    }

    public static void printEndMessage(){
        System.out.println("Obrigado por utilizar o Conversor de Moeda!");
    }

    public static void printValueRequest(){
        System.out.println("Digite o valor que deseja converter:");
    }

    public static void printExchangeResult(double valueToConvert, String baseCurrency, double conversionRate, String targetCurrency) {
        System.out.printf("Valor %.2f [%s] corresponde ao valor final de -> %.2f [%s].\n", valueToConvert, baseCurrency, valueToConvert * conversionRate, targetCurrency);
    }





}
