package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class HuobiSwapAccount {

    private String symbol;
    private BigDecimal marginBalance;
    private BigDecimal marginPosition;
    private BigDecimal marginFrozen;
    private BigDecimal marginAvailable;
    private BigDecimal profitReal;
    private BigDecimal profitUnreal;
    private BigDecimal riskRate;
    private BigDecimal withdrawAvailable;
    private BigDecimal liquidationPrice;
    private BigDecimal leverRate;
    private BigDecimal adjustFactor;
    private BigDecimal marginStatic;
    private String contractCode;


    public HuobiSwapAccount(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("margin_balance")BigDecimal marginBalance,
            @JsonProperty("margin_position")BigDecimal marginPosition,
            @JsonProperty("margin_frozen")BigDecimal marginFrozen,
            @JsonProperty("margin_available")BigDecimal marginAvailable,
            @JsonProperty("profit_real")BigDecimal profitReal,
            @JsonProperty("profit_unreal")BigDecimal profitUnreal,
            @JsonProperty("risk_rate")BigDecimal riskRate,
            @JsonProperty("withdraw_available")BigDecimal withdrawAvailable,
            @JsonProperty("liquidation_price")BigDecimal liquidationPrice,
            @JsonProperty("lever_rate")BigDecimal leverRate,
            @JsonProperty("adjust_factor")BigDecimal adjustFactor,
            @JsonProperty("margin_static")BigDecimal marginStatic,
            @JsonProperty("contract_code")String contractCode) {
        this.symbol = symbol;
        this.marginBalance = marginBalance;
        this.marginPosition = marginPosition;
        this.marginFrozen = marginFrozen;
        this.marginAvailable = marginAvailable;
        this.profitReal = profitReal;
        this.profitUnreal = profitUnreal;
        this.riskRate = riskRate;
        this.withdrawAvailable = withdrawAvailable;
        this.liquidationPrice = liquidationPrice;
        this.leverRate = leverRate;
        this.adjustFactor = adjustFactor;
        this.marginStatic = marginStatic;
        this.contractCode = contractCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(BigDecimal marginBalance) {
        this.marginBalance = marginBalance;
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

    public BigDecimal getProfitReal() {
        return profitReal;
    }

    public void setProfitReal(BigDecimal profitReal) {
        this.profitReal = profitReal;
    }

    public BigDecimal getProfitUnreal() {
        return profitUnreal;
    }

    public void setProfitUnreal(BigDecimal profitUnreal) {
        this.profitUnreal = profitUnreal;
    }

    public BigDecimal getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(BigDecimal riskRate) {
        this.riskRate = riskRate;
    }

    public BigDecimal getWithdrawAvailable() {
        return withdrawAvailable;
    }

    public void setWithdrawAvailable(BigDecimal withdrawAvailable) {
        this.withdrawAvailable = withdrawAvailable;
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

    public BigDecimal getMarginStatic() {
        return marginStatic;
    }

    public void setMarginStatic(BigDecimal marginStatic) {
        this.marginStatic = marginStatic;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    @Override
    public String toString() {
        return "HuobiSwapAccount{" +
                "symbol='" + symbol + '\'' +
                ", marginBalance=" + marginBalance +
                ", marginPosition=" + marginPosition +
                ", marginFrozen=" + marginFrozen +
                ", marginAvailable=" + marginAvailable +
                ", profitReal=" + profitReal +
                ", profitUnreal=" + profitUnreal +
                ", riskRate=" + riskRate +
                ", withdrawAvailable=" + withdrawAvailable +
                ", liquidationPrice=" + liquidationPrice +
                ", leverRate=" + leverRate +
                ", adjustFactor=" + adjustFactor +
                ", marginStatic=" + marginStatic +
                ", contractCode='" + contractCode + '\'' +
                '}';
    }
}
