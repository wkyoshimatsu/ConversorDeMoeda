package me.wky.conversorDeMoeda.model;

public class ScreenMessage {
    private static final String[][] EXCHANGE_OPTIONS = {
            {"BRL","USD"},
            {"USD","BRL"},
            {"BRL","ARS"},
            {"ARS","BRL"},
            {"BRL","JPY"},
            {"JPY","BRL"}
    };

    private static final String[] CURRENCY_CODE_AND_DESCRIPTION = {
            "Real (BRL)",
            "Dólar Americano (USD)",
            "Peso Argentino (ARS)",
            "Iene Japonês (JPY)",

    };

    public static void printExchangeOptions(){
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
                ***************************************************
                """);
    }

    public static String getBaseCurrency(int option){
        return EXCHANGE_OPTIONS[option - 1][0];
    }

    public static String getTargetCurrency(int option){
        return EXCHANGE_OPTIONS[option - 1][1];
    }

    public static void

    public static void valueRequest(){
        System.out.println("Digite o valor que deseja converter:");
    }

    public static void exchangeResult(double valueToConvert, String baseCurrency, double conversionRate, String targetCurrency) {
        System.out.printf("Valor %.2f [%s] corresponde ao valor final de -> %.2f [%s].\n", valueToConvert, baseCurrency, valueToConvert * conversionRate, targetCurrency);
    }




}
