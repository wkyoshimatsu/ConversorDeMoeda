package me.wky.conversorDeMoeda.models;

public record ConversionFromBaseToTargetCurrencyExchangeRate(String base_code, String target_code, float conversion_rate) {
}
