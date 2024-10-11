package me.wky.conversorDeMoeda.util.exchangeRateApi;

import java.util.Map;

public record ConversionFromBaseCurrencyExchangeRate(String base_code, Map<String, Float> conversion_rates) {
}
