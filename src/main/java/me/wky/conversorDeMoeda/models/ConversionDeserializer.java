package me.wky.conversorDeMoeda.models;

import com.google.gson.Gson;

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
