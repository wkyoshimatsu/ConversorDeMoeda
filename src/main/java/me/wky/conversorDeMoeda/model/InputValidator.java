package me.wky.conversorDeMoeda.model;

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

    public static String getCustomBaseCurrency(int option){
        Scanner scanner = new Scanner(System.in);

        String baseCurrency;
        while (true){
            ScreenMessage.printAllCurrencyCodes();
            baseCurrency = scanner.nextLine().toUpperCase();
            if (Currency.STANDARD_CURRENCIES.containsKey(baseCurrency)){
                break;
            }
        }
        return baseCurrency;
    }
}
