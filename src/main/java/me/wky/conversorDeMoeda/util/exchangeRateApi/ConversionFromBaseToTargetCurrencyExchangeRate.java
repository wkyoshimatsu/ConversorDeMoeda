package me.wky.conversorDeMoeda.util.exchangeRateApi;

public record ConversionFromBaseToTargetCurrencyExchangeRate(String base_code, String target_code, float conversion_rate) {
}
