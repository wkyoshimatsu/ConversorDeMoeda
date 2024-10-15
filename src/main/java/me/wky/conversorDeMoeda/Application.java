package me.wky.conversorDeMoeda;

import me.wky.conversorDeMoeda.model.Calculator;
import me.wky.conversorDeMoeda.model.InputValidator;
import me.wky.conversorDeMoeda.model.ScreenMessage;

import java.io.IOException;

public class Application {

    public static final String API_KEY= System.getenv("API_KEY");

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true){
            int option = InputValidator.exchangeSelector();
            if (option == ScreenMessage.EXIT_OPTION){
                ScreenMessage.printEndMessage();
                break;
            } else if (option != ScreenMessage.CUSTOM_OPTION){
                Calculator.standardCalculator(option);
            } else {
                Calculator.customCalculator();
            }
        }
    }
}
