package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class HuobiLinearSwapCrossDetailAccount {

    private String symbol;
    private String contractCode;
    private BigDecimal marginPosition;
    private BigDecimal marginFrozen;
    private BigDecimal marginAvailable;
    private BigDecimal profitUnreal;
    private BigDecimal liquidationPrice;
    private BigDecimal leverRate;
    private BigDecimal adjustFactor;

    public HuobiLinearSwapCrossDetailAccount(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("margin_position")BigDecimal marginPosition,
            @JsonProperty("margin_frozen")BigDecimal marginFrozen,
            @JsonProperty("margin_available")BigDecimal marginAvailable,
            @JsonProperty("profit_unreal")BigDecimal profitUnreal,
            @JsonProperty("liquidation_price")BigDecimal liquidationPrice,
            @JsonProperty("lever_rate")BigDecimal leverRate,
            @JsonProperty("adjust_factor")BigDecimal adjustFactor) {
        this.symbol = symbol;
        this.contractCode = contractCode;
        this.marginPosition = marginPosition;
        this.marginFrozen = marginFrozen;
        this.marginAvailable = marginAvailable;
        this.profitUnreal = profitUnreal;
        this.liquidationPrice = liquidationPrice;
        this.leverRate = leverRate;
        this.adjustFactor = adjustFactor;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public BigDecimal getMarginPosition() {
        return marginPosition;
    }

    public void setMarginPosition(BigDecimal marginPosition) {
        this.marginPosition = marginPosition;
    }

    public BigDecimal getMarginFrozen() {
        return marginFrozen;
    }

    public void setMarginFrozen(BigDecimal marginFrozen) {
        this.marginFrozen = marginFrozen;
    }

    public BigDecimal getMarginAvailable() {
        return marginAvailable;
    }

    public void setMarginAvailable(BigDecimal marginAvailable) {
        this.marginAvailable = marginAvailable;
    }

    public BigDecimal getProfitUnreal() {
        return profitUnreal;
    }

    public void setProfitUnreal(BigDecimal profitUnreal) {
        this.profitUnreal = profitUnreal;
    }

    public BigDecimal getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(BigDecimal liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public BigDecimal getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(BigDecimal leverRate) {
        this.leverRate = leverRate;
    }

    public BigDecimal getAdjustFactor() {
        return adjustFactor;
    }

    public void setAdjustFactor(BigDecimal adjustFactor) {
        this.adjustFactor = adjustFactor;
    }

    @Override
    public String toString() {
        return "HuobiLinearSwapCrossDetailAccount{" +
                "symbol='" + symbol + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", marginPosition=" + marginPosition +
                ", marginFrozen=" + marginFrozen +
                ", marginAvailable=" + marginAvailable +
                ", profitUnreal=" + profitUnreal +
                ", liquidationPrice=" + liquidationPrice +
                ", leverRate=" + leverRate +
                ", adjustFactor=" + adjustFactor +
                '}';
    }
}
