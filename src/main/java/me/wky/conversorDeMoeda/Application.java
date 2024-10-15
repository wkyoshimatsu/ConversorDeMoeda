package me.wky.conversorDeMoeda;

import me.wky.conversorDeMoeda.model.Currency;
import me.wky.conversorDeMoeda.model.InputValidator;
import me.wky.conversorDeMoeda.model.ScreenMessage;
import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseCurrency;
import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseToTargetCurrency;
import me.wky.conversorDeMoeda.util.ConversionDeserializer;
import me.wky.conversorDeMoeda.util.HttpResponseFactory;
import me.wky.conversorDeMoeda.util.exchangeRateApi.ExchangeRateAPI;

import java.io.IOException;
import java.util.List;

public class Application {

    public static final String API_KEY= System.getenv("API_KEY");

    public static void main(String[] args) throws IOException, InterruptedException {

        int option = 0;

        while (true){

            String baseCurrency;
            String targetCurrency;
            double valueToConvert;
            float conversionRate;

            option = InputValidator.exchangeSelector();

            if (option == ScreenMessage.EXIT_OPTION){

                ScreenMessage.printEndMessage();
                break;

            } else if (option != ScreenMessage.CUSTOM_OPTION){

                baseCurrency = Currency.getBaseCurrency(option);
                targetCurrency = Currency.getTargetCurrency(option);

                valueToConvert = InputValidator.getValueToConvert();

                ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI(baseCurrency, targetCurrency);

                String json = HttpResponseFactory
                        .getJsonByUrl(exchangeRateAPI
                                .getUrlWithBaseAndTargetCurrency());

                ConversionFromBaseToTargetCurrency conversionFromBaseToTargetCurrency = ConversionDeserializer
                        .deserializeToConversionFromBaseToTargetCurrency(json);

                conversionRate = conversionFromBaseToTargetCurrency.getConversionRate();

                ScreenMessage.printExchangeResult(valueToConvert,
                        baseCurrency,
                        conversionRate,
                        targetCurrency);
            } else {
                Calculator.customCalculator();
            }
        }
    }
}
