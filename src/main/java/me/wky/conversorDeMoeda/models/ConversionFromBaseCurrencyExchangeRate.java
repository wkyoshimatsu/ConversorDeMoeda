package me.wky.conversorDeMoeda.models;

import java.util.Map;

public record ConversionFromBaseCurrencyExchangeRate(String base_code, Map<String, Float> conversion_rates) {
}
