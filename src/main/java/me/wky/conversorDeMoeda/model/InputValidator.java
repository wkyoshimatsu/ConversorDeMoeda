package me.wky.conversorDeMoeda.model;

import java.util.List;
import java.util.Scanner;

public class InputValidator {
    public static int exchangeSelector() {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option < 1 || option > ScreenMessage.EXIT_OPTION){
            ScreenMessage.printExchangeOptions();
            option = scanner.nextInt();
        }
        return option;
    }

    public static double getValueToConvert(){
        Scanner scanner = new Scanner(System.in);

        double valueToConvert = 0;
        while (valueToConvert <= 0){
            ScreenMessage.printValueRequest();
            valueToConvert = scanner.nextDouble();
        }
        return valueToConvert;
    }

    public static String getCustomBaseCurrency(List<String> currencies){
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option < 1 || option > currencies.size() + 1){
            System.out.println("Selecione a moeda base:");
            ScreenMessage.printAllCurrencyCodes(currencies);
            option = scanner.nextInt();
        }
        return currencies.get(option - 1);
    }

    public static String getCustomTargetCurrency(String customBaseCurrency, List<String> currencies){
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option < 1 || option > currencies.size() + 1){
            System.out.println("Selecione a moeda de destino:");
            ScreenMessage.printAllCurrencyCodes(currencies);
            option = scanner.nextInt();

            if (currencies.get(option - 1).equals(customBaseCurrency)){
                System.out.println("A moeda de destino não pode ser a mesma que a moeda base.");
                option = 0;
            }
        }
        return currencies.get(option - 1);
    }
}
