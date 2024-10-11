package me.wky.conversorDeMoeda.model.conversion;

import java.util.Map;

public record ConversionFromBaseCurrencyExchangeRate(String base_code, Map<String, Float> conversion_rates) {
}
