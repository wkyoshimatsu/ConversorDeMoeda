package me.wky.conversorDeMoeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Application {

    public static final String API_KEY= System.getenv("API_KEY");

    public static void main(String[] args) throws IOException, InterruptedException {
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

        }

        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url_str)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        /*
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();
        */
    }
}
