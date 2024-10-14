package me.wky.conversorDeMoeda.model;

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

    //List<> currencies;
}
