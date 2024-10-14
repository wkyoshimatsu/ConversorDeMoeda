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
}
