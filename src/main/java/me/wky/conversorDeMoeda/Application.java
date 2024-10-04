package me.wky.conversorDeMoeda;

import com.google.gson.Gson;
import me.wky.conversorDeMoeda.models.*;

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

    public static int exchangeSelector() {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (option < 1 || option > 7){
            System.out.println("""
                ***************************************************
                      Seja bem-vindo(a) ao Conversor de Moeda
                
                1) Real (BRL)             ->  Dólar Americano (USD)
                2) Dólar Americano (USD)  ->  Real (BRL)
                3) Real (BRL)             ->  Peso Argentino (ARS)
                4) Peso Argentino (ARS)   ->  Real (BRL)
                5) Real (BRL)             ->  Iene (JPY)
                6) Iene (JPY)             ->  Real (BRL)
                7) Sair
                
                Selecione uma opção válida:
                ***************************************************""");
            option = scanner.nextInt();
        }
        return option;
    }

    public static double getValueToConvert(){
        Scanner scanner = new Scanner(System.in);

        double valueToConvert = 0;
        while (valueToConvert <= 0){
            System.out.println("Digite o valor que deseja converter:");
            valueToConvert = scanner.nextDouble();
        }
        return valueToConvert;
    }

    public static HttpResponse<String> getHttpResponseByUrl(String url_str) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int option = 0;
        while (option != 7){
            option = exchangeSelector();

            String baseCurrency = "";
            String targetCurrency = "";

            switch (option){
                case 1:
                    baseCurrency = "BRL";
                    targetCurrency = "USD";
                    break;
                case 2:
                    baseCurrency = "USD";
                    targetCurrency = "BRL";
                    break;
                case 3:
                    baseCurrency = "BRL";
                    targetCurrency = "ARS";
                    break;
                case 4:
                    baseCurrency = "ARS";
                    targetCurrency = "BRL";
                    break;
                case 5:
                    baseCurrency = "BRL";
                    targetCurrency = "JPY";
                    break;
                case 6:
                    baseCurrency = "JPY";
                    targetCurrency = "BRL";
                    break;
                case 7:
                    System.out.println("Até mais!");
                    break;
            }

            if (option == 7){
                break;
            }

            double valueToConvert = getValueToConvert();

            String url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;

            HttpResponse<String> response = getHttpResponseByUrl(url_str);

            String json = response.body();

            //System.out.println(json);

            ConversionFromBaseToTargetCurrency conversionFromBaseToTargetCurrency = ConversionDeserializer.deserializeToConversionFromBaseToTargetCurrency(json);

            float conversionRate = conversionFromBaseToTargetCurrency.getConversionRate();

            System.out.printf("Valor %.2f [%s] corresponde ao valor final de -> %.2f [%s].\n", valueToConvert, baseCurrency, valueToConvert * conversionRate, targetCurrency);

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
