package me.wky.conversorDeMoeda;

import me.wky.conversorDeMoeda.model.InputValidator;
import me.wky.conversorDeMoeda.model.ScreenMessage;
import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseCurrency;
import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseToTargetCurrency;
import me.wky.conversorDeMoeda.util.ConversionDeserializer;
import me.wky.conversorDeMoeda.util.HttpResponseFactory;
import me.wky.conversorDeMoeda.util.exchangeRateApi.ExchangeRateAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static final String API_KEY= System.getenv("API_KEY");

    public static void main(String[] args) throws IOException, InterruptedException {

        /*
        mostra tela inicial
        seleciona opção

        if (não sair)
            seleciona valor
            converte

        */

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

                baseCurrency = ScreenMessage.getBaseCurrency(option);
                targetCurrency = ScreenMessage.getTargetCurrency(option);

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
                        valueToConvert * conversionRate,
                        targetCurrency);
            } else {







                baseCurrency = ScreenMessage.getBaseCurrency(option);
                targetCurrency = ScreenMessage.getTargetCurrency(option);

                valueToConvert = InputValidator.getValueToConvert();

                ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI(baseCurrency, targetCurrency);

                String json = HttpResponseFactory
                        .getJsonByUrl(exchangeRateAPI
                                .getUrlWithBaseCurrency());

                ConversionFromBaseCurrency conversionFromBaseCurrency = ConversionDeserializer
                        .deserializeToConversionFromBaseCurrency(json);

                Map<Integer, String> baseCodeOptions = new HashMap<>();

                int index = 1;
                for (String baseCode : conversionFromBaseCurrency.getConversionRates().keySet()) {
                    baseCodeOptions.put(index, baseCode);
                    index++;
                }

                int baseCodeOption = 0;
                while (true){
                    System.out.println("Selecione a moeda base:");
                    for (int i = 1; i <= baseCodeOptions.size(); i++) {
                        System.out.printf("%d) %s\n", i, baseCodeOptions.get(i));
                    }
                    baseCodeOption = new Scanner(System.in).nextInt();
                    if (baseCodeOptions.containsKey(baseCodeOption)){
                        break;
                    }
                }

                String selectedBaseCode = baseCodeOptions.get(baseCodeOption);

                json = HttpResponseFactory
                        .getJsonByUrl("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + selectedBaseCode + "/" + targetCurrency);

                ConversionFromBaseToTargetCurrency conversionFromBaseToTargetCurrency = ConversionDeserializer
                        .deserializeToConversionFromBaseToTargetCurrency(json);

                conversionRate = conversionFromBaseToTargetCurrency.getConversionRate();

                ScreenMessage.printExchangeResult(valueToConvert,
                        selectedBaseCode,
                        valueToConvert * conversionRate,
                        targetCurrency);



                //

                url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/BRL";

                response = getHttpResponseByUrl(url_str);

                json = response.body();

                //System.out.println(json);

                ConversionFromBaseCurrency conversionFromBaseCurrency = ConversionDeserializer.deserializeToConversionFromBaseCurrency(json);

                //System.out.println(conversionFromBaseCurrency.getConversionRates());

                Map<Integer, String> baseCodeOptions = new HashMap<>();

                int index = 1;
                for (String baseCode : conversionFromBaseCurrency.getConversionRates().keySet()) {
                    baseCodeOptions.put(index, baseCode);
                    index++;
                }

                //System.out.println(baseCodeOptions);







                //gson = new Gson();
                //ConversionExchangeRate conversion = gson.fromJson(json, ConversionExchangeRate.class);
            }

        }
    }
}
