package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class HistoricalFundingRate {
    private BigDecimal avgPremiumIndex;
    private BigDecimal fundingRate;
    private BigDecimal realizedRate;
    private long fundingTime;
    private String contractCode;
    private String symbol;
    private String feeAsset;


    public HistoricalFundingRate(
            @JsonProperty("avg_premium_index")BigDecimal avgPremiumIndex,
            @JsonProperty("funding_rate")BigDecimal fundingRate,
            @JsonProperty("realized_rate")BigDecimal realizedRate,
            @JsonProperty("funding_time")long fundingTime,
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("symbol")String symbol,
            @JsonProperty("fee_asset")String feeAsset) {
        this.avgPremiumIndex = avgPremiumIndex;
        this.fundingRate = fundingRate;
        this.realizedRate = realizedRate;
        this.fundingTime = fundingTime;
        this.contractCode = contractCode;
        this.symbol = symbol;
        this.feeAsset = feeAsset;
    }

    public BigDecimal getAvgPremiumIndex() {
        return avgPremiumIndex;
    }

    public void setAvgPremiumIndex(BigDecimal avgPremiumIndex) {
        this.avgPremiumIndex = avgPremiumIndex;
    }

    public BigDecimal getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(BigDecimal fundingRate) {
        this.fundingRate = fundingRate;
    }

    public BigDecimal getRealizedRate() {
        return realizedRate;
    }

    public void setRealizedRate(BigDecimal realizedRate) {
        this.realizedRate = realizedRate;
    }

    public long getFundingTime() {
        return fundingTime;
    }

    public void setFundingTime(long fundingTime) {
        this.fundingTime = fundingTime;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    @Override
    public String toString() {
        return "HistoricalFundingRate{" +
                "avgPremiumIndex=" + avgPremiumIndex +
                ", fundingRate=" + fundingRate +
                ", realizedRate=" + realizedRate +
                ", fundingTime=" + fundingTime +
                ", contractCode='" + contractCode + '\'' +
                ", symbol='" + symbol + '\'' +
                ", feeAsset='" + feeAsset + '\'' +
                '}';
    }
}
