package me.wky.conversorDeMoeda.model.conversion;

public class ConversionFromBaseToTargetCurrency {
    String baseCurrencyCode;
    String targetCurrencyCode;
    float conversionRate;

    public ConversionFromBaseToTargetCurrency(ConversionFromBaseToTargetCurrencyExchangeRate conversionFromBaseToTargetCurrencyExchangeRate) {
        this.baseCurrencyCode = conversionFromBaseToTargetCurrencyExchangeRate.base_code();
        this.targetCurrencyCode = conversionFromBaseToTargetCurrencyExchangeRate.target_code();
        this.conversionRate = conversionFromBaseToTargetCurrencyExchangeRate.conversion_rate();
    }

    public float getConversionRate() {
        return conversionRate;
    }
}
