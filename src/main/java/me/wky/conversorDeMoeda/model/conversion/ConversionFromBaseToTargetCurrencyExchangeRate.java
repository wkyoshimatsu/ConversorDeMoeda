package me.wky.conversorDeMoeda.model.conversion;

public record ConversionFromBaseToTargetCurrencyExchangeRate(String base_code, String target_code, float conversion_rate) {
}
