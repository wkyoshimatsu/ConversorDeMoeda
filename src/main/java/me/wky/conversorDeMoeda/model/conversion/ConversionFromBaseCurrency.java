package me.wky.conversorDeMoeda.model.conversion;

import me.wky.conversorDeMoeda.util.exchangeRateApi.ConversionFromBaseCurrencyExchangeRate;

import java.util.Map;

public class ConversionFromBaseCurrency {
    String baseCurrencyCode;
    Map<String, Float> conversionRates;

    public ConversionFromBaseCurrency(ConversionFromBaseCurrencyExchangeRate conversionFromBaseCurrencyExchangeRate) {
        this.baseCurrencyCode = conversionFromBaseCurrencyExchangeRate.base_code();
        this.conversionRates = conversionFromBaseCurrencyExchangeRate.conversion_rates();
    }

    public Map<String, Float> getConversionRates() {
        return conversionRates;
    }
}
