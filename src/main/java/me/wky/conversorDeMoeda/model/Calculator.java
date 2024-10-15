package me.wky.conversorDeMoeda.model;

import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseToTargetCurrency;
import me.wky.conversorDeMoeda.util.ConversionDeserializer;
import me.wky.conversorDeMoeda.util.HttpResponseFactory;
import me.wky.conversorDeMoeda.util.exchangeRateApi.ExchangeRateAPI;

import java.io.IOException;
import java.util.List;

public class Calculator {
    private static String baseCurrency;
    private static String targetCurrency;
    private static double valueToConvert;
    private static float conversionRate;

    public Calculator() throws IOException, InterruptedException {
    }

    public static float getConversionRateFromAPI() throws IOException, InterruptedException {
        ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI(baseCurrency, targetCurrency);

        String json = HttpResponseFactory
                .getJsonByUrl(exchangeRateAPI
                        .getUrlWithBaseAndTargetCurrency());

        ConversionFromBaseToTargetCurrency conversionFromBaseToTargetCurrency = ConversionDeserializer
                .deserializeToConversionFromBaseToTargetCurrency(json);

        return conversionFromBaseToTargetCurrency.getConversionRate();
    }


    public static void standardCalculator(int option) throws IOException, InterruptedException {
        baseCurrency = Currency.getBaseCurrency(option);
        targetCurrency = Currency.getTargetCurrency(option);

        valueToConvert = InputValidator.getValueToConvert();

        conversionRate = getConversionRateFromAPI();

        ScreenMessage.printExchangeResult(valueToConvert,
                baseCurrency,
                conversionRate,
                targetCurrency);
    }

    public static void customCalculator() throws IOException, InterruptedException {
        List<String> baseCodeOptions = new Currency().getCurrenciesAvailables();
        baseCurrency = InputValidator.getCustomBaseCurrency(baseCodeOptions);
        targetCurrency = InputValidator.getCustomTargetCurrency(baseCurrency, baseCodeOptions);

        valueToConvert = InputValidator.getValueToConvert();

        conversionRate = getConversionRateFromAPI();

        ScreenMessage.printExchangeResult(valueToConvert,
                baseCurrency,
                conversionRate,
                targetCurrency);
    }
}
