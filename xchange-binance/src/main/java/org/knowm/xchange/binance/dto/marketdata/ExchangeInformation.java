package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExchangeInformation {


    public ExchangeInformation(
            @JsonProperty("timezone") String timezone,
            @JsonProperty("serverTime") Long serverTime,
            @JsonProperty("rateLimits") List<RateLimit> rateLimits,
            @JsonProperty("exchangeFilters") List<ExchangeFilter> exchangeFilters,
            @JsonProperty("symbols") List<ExchangeInfoEntry> symbols) {
        this.timezone = timezone;
        this.serverTime = serverTime;
        this.rateLimits = rateLimits;
        this.exchangeFilters = exchangeFilters;
        this.symbols = symbols;
    }

    private String timezone;

    private Long serverTime;

    private List<RateLimit> rateLimits;

    private List<ExchangeFilter> exchangeFilters;

    private List<ExchangeInfoEntry> symbols;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public List<RateLimit> getRateLimits() {
        return rateLimits;
    }

    public void setRateLimits(List<RateLimit> rateLimits) {
        this.rateLimits = rateLimits;
    }

    public List<ExchangeFilter> getExchangeFilters() {
        return exchangeFilters;
    }

    public void setExchangeFilters(List<ExchangeFilter> exchangeFilters) {
        this.exchangeFilters = exchangeFilters;
    }

    public List<ExchangeInfoEntry> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<ExchangeInfoEntry> symbols) {
        this.symbols = symbols;
    }
}
