package me.wky.conversorDeMoeda.model;

import java.util.List;

public class ScreenMessage {

    public static final int CUSTOM_OPTION = Currency.EXCHANGE_OPTIONS_SIZE + 1;

    public static final int EXIT_OPTION = Currency.EXCHANGE_OPTIONS_SIZE + 2;

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


    public static void printAllCurrencyCodes(List<String> currencyCodes){
        int numberOfColumns = 7;
        int columnSize = (int) Math.ceil(currencyCodes.size() / numberOfColumns + 1);
        int indexOfCurrencyCode;
        String indexToPrint;

        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                indexOfCurrencyCode = i + (j * columnSize);

                if (indexOfCurrencyCode + 1 < 10){
                    indexToPrint = "  " + String.valueOf(indexOfCurrencyCode + 1);
                } else if (indexOfCurrencyCode + 1 < 100){
                    indexToPrint = " " + String.valueOf(indexOfCurrencyCode + 1);
                } else {
                    indexToPrint = String.valueOf(indexOfCurrencyCode + 1);
                }

                if (j != numberOfColumns - 1) {
                    System.out.printf("%s) %s\t\t", indexToPrint, currencyCodes.get(indexOfCurrencyCode));
                } else if (indexOfCurrencyCode < currencyCodes.size()){
                    System.out.printf("%s) %s\n", indexToPrint, currencyCodes.get(indexOfCurrencyCode));
                } else {
                    System.out.print("\n");
                }
            }
        }
    }

    public static String getBaseCurrency(int option){
        return Currency.STANDARD_EXCHANGE_OPTIONS[option - 1][0];
    }

    public static String getTargetCurrency(int option){
        return Currency.STANDARD_EXCHANGE_OPTIONS[option - 1][1];
    }

    public static void printEndMessage(){
        System.out.println("Obrigado por utilizar o Conversor de Moeda!");
    }

    public static void printValueRequest(){
        System.out.println("Digite o valor que deseja converter:");
    }

    private static String formatValueBasedOnCurrency(double valueToConvert, String currency){
        if (Currency.CURRENCIES_WITHOUT_CENTS.contains(currency)){
            return String.format("%.0f", valueToConvert);
        }
        return String.format("%.2f", valueToConvert);
    }

    public static void printExchangeResult(double valueToConvert,
                                           String baseCurrency,
                                           double conversionRate,
                                           String targetCurrency) {

        String valueToConvertString = formatValueBasedOnCurrency(valueToConvert, baseCurrency);
        String valueConvertedString = formatValueBasedOnCurrency(valueToConvert * conversionRate, targetCurrency);

        System.out.printf("Valor %s [%s] corresponde ao valor final de -> %s [%s].\n\n",
                valueToConvertString,
                baseCurrency,
                valueConvertedString,
                targetCurrency);
    }
}
