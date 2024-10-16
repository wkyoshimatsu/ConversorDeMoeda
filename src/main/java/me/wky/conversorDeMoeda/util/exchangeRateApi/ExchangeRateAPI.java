package me.wky.conversorDeMoeda.util.exchangeRateApi;

import static me.wky.conversorDeMoeda.Application.API_KEY;

public class ExchangeRateAPI {
    public static final String urlWithBaseCurrency = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/BRL";

    private String baseCurrency;
    private String targetCurrency;
    private String urlWithBaseAndTargetCurrency;

    public ExchangeRateAPI(String baseCurrency, String targetCurrency) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.urlWithBaseAndTargetCurrency = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public String getUrlWithBaseCurrency() {
        return urlWithBaseCurrency;
    }

    public String getUrlWithBaseAndTargetCurrency() {
        return urlWithBaseAndTargetCurrency;
    }
}
