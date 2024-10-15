package me.wky.conversorDeMoeda.model;

import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseCurrency;
import me.wky.conversorDeMoeda.util.ConversionDeserializer;
import me.wky.conversorDeMoeda.util.HttpResponseFactory;
import me.wky.conversorDeMoeda.util.exchangeRateApi.ExchangeRateAPI;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Currency {
    static final Map<String, String> STANDARD_CURRENCIES = Map.of(
            "BRL", "Real (BRL)            ",
            "USD", "Dólar Americano (USD) ",
            "ARS", "Peso Argentino (ARS)  ",
            "JPY", "Iene Japonês (JPY)    ");

    static final String[][] STANDARD_EXCHANGE_OPTIONS = {
                    {"BRL","USD"},
                    {"USD","BRL"},
                    {"BRL","ARS"},
                    {"ARS","BRL"},
                    {"BRL","JPY"},
                    {"JPY","BRL"}
            };

    static final List<String> CURRENCIES_WITHOUT_CENTS = List.of(
            "JPY");

    static final int EXCHANGE_OPTIONS_SIZE = STANDARD_EXCHANGE_OPTIONS.length;

    public static String getBaseCurrency(int option){
        return STANDARD_EXCHANGE_OPTIONS[option - 1][0];
    }

    public static String getTargetCurrency(int option){
        return STANDARD_EXCHANGE_OPTIONS[option - 1][1];
    }

    private List<String> currenciesAvailables;

    public Currency() throws IOException, InterruptedException {
        String json = HttpResponseFactory
                .getJsonByUrl(ExchangeRateAPI.urlWithBaseCurrency);

        ConversionFromBaseCurrency conversionFromBaseCurrency = ConversionDeserializer
                .deserializeToConversionFromBaseCurrency(json);

        currenciesAvailables = List.copyOf(conversionFromBaseCurrency.getConversionRates().keySet());
    }

    public List<String> getCurrenciesAvailables() {
        return currenciesAvailables;
    }
}
