package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class FundingRate {

    private BigDecimal estimatedRate;
    private BigDecimal fundingRate;
    private String contractCode;
    private String symbol;
    private String feeAsset;
    private long fundingTime;
    private long nextFundingTime;

    public FundingRate(
            @JsonProperty("estimated_rate")BigDecimal estimatedRate,
            @JsonProperty("funding_rate")BigDecimal fundingRate,
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("symbol")String symbol,
            @JsonProperty("fee_asset")String feeAsset,
            @JsonProperty("funding_time")long fundingTime,
            @JsonProperty("next_funding_time")long nextFundingTime) {
        this.estimatedRate = estimatedRate;
        this.fundingRate = fundingRate;
        this.contractCode = contractCode;
        this.symbol = symbol;
        this.feeAsset = feeAsset;
        this.fundingTime = fundingTime;
        this.nextFundingTime = nextFundingTime;
    }

    public BigDecimal getEstimatedRate() {
        return estimatedRate;
    }

    public void setEstimatedRate(BigDecimal estimatedRate) {
        this.estimatedRate = estimatedRate;
    }

    public BigDecimal getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(BigDecimal fundingRate) {
        this.fundingRate = fundingRate;
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

    public long getFundingTime() {
        return fundingTime;
    }

    public void setFundingTime(long fundingTime) {
        this.fundingTime = fundingTime;
    }

    public long getNextFundingTime() {
        return nextFundingTime;
    }

    public void setNextFundingTime(long nextFundingTime) {
        this.nextFundingTime = nextFundingTime;
    }

    @Override
    public String toString() {
        return "FundingRate{" +
                "estimatedRate=" + estimatedRate +
                ", fundingRate=" + fundingRate +
                ", contractCode='" + contractCode + '\'' +
                ", symbol='" + symbol + '\'' +
                ", feeAsset='" + feeAsset + '\'' +
                ", fundingTime=" + fundingTime +
                ", nextFundingTime=" + nextFundingTime +
                '}';
    }
}
