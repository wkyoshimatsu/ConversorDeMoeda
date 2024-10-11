package me.wky.conversorDeMoeda.util;

import com.google.gson.Gson;
import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseCurrency;
import me.wky.conversorDeMoeda.util.exchangeRateApi.ConversionFromBaseCurrencyExchangeRate;
import me.wky.conversorDeMoeda.model.conversion.ConversionFromBaseToTargetCurrency;
import me.wky.conversorDeMoeda.util.exchangeRateApi.ConversionFromBaseToTargetCurrencyExchangeRate;

public class ConversionDeserializer {

    public static ConversionFromBaseToTargetCurrency deserializeToConversionFromBaseToTargetCurrency(String json){
        Gson gson = new Gson();
        ConversionFromBaseToTargetCurrencyExchangeRate conversionFromBaseToTargetCurrencyExchangeRate = gson
                .fromJson(json, ConversionFromBaseToTargetCurrencyExchangeRate.class);
        return new ConversionFromBaseToTargetCurrency(conversionFromBaseToTargetCurrencyExchangeRate);
    }

    public static ConversionFromBaseCurrency deserializeToConversionFromBaseCurrency(String json){
        Gson gson = new Gson();
        ConversionFromBaseCurrencyExchangeRate conversionFromBaseCurrencyExchangeRate = gson
                .fromJson(json, ConversionFromBaseCurrencyExchangeRate.class);
        return new ConversionFromBaseCurrency(conversionFromBaseCurrencyExchangeRate);
    }


}
