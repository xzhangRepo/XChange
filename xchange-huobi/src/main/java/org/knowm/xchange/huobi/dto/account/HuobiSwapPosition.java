package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class HuobiSwapPosition {

    private String symbol;
    private String contractCode;
    private BigDecimal volume;
    private BigDecimal available;
    private BigDecimal frozen;
    private BigDecimal costOpen;
    private BigDecimal costHold;
    private BigDecimal profitUnreal;
    private BigDecimal profitRate;
    private BigDecimal leverRate;
    private BigDecimal positionMargin;
    private String direction;
    private BigDecimal profit;
    private BigDecimal lastPrice;

    public HuobiSwapPosition(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("volume")BigDecimal volume,
            @JsonProperty("available")BigDecimal available,
            @JsonProperty("frozen")BigDecimal frozen,
            @JsonProperty("cost_open")BigDecimal costOpen,
            @JsonProperty("cost_hold")BigDecimal costHold,
            @JsonProperty("profit_unreal")BigDecimal profitUnreal,
            @JsonProperty("profit_rate")BigDecimal profitRate,
            @JsonProperty("lever_rate")BigDecimal leverRate,
            @JsonProperty("position_margin")BigDecimal positionMargin,
            @JsonProperty("direction")String direction,
            @JsonProperty("profit")BigDecimal profit,
            @JsonProperty("last_price")BigDecimal lastPrice) {
        this.symbol = symbol;
        this.contractCode = contractCode;
        this.volume = volume;
        this.available = available;
        this.frozen = frozen;
        this.costOpen = costOpen;
        this.costHold = costHold;
        this.profitUnreal = profitUnreal;
        this.profitRate = profitRate;
        this.leverRate = leverRate;
        this.positionMargin = positionMargin;
        this.direction = direction;
        this.profit = profit;
        this.lastPrice = lastPrice;
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

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public BigDecimal getFrozen() {
        return frozen;
    }

    public void setFrozen(BigDecimal frozen) {
        this.frozen = frozen;
    }

    public BigDecimal getCostOpen() {
        return costOpen;
    }

    public void setCostOpen(BigDecimal costOpen) {
        this.costOpen = costOpen;
    }

    public BigDecimal getCostHold() {
        return costHold;
    }

    public void setCostHold(BigDecimal costHold) {
        this.costHold = costHold;
    }

    public BigDecimal getProfitUnreal() {
        return profitUnreal;
    }

    public void setProfitUnreal(BigDecimal profitUnreal) {
        this.profitUnreal = profitUnreal;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(BigDecimal profitRate) {
        this.profitRate = profitRate;
    }

    public BigDecimal getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(BigDecimal leverRate) {
        this.leverRate = leverRate;
    }

    public BigDecimal getPositionMargin() {
        return positionMargin;
    }

    public void setPositionMargin(BigDecimal positionMargin) {
        this.positionMargin = positionMargin;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    @Override
    public String toString() {
        return "HuobiSwapPosition{" +
                "symbol='" + symbol + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", volume=" + volume +
                ", available=" + available +
                ", frozen=" + frozen +
                ", costOpen=" + costOpen +
                ", costHold=" + costHold +
                ", profitUnreal=" + profitUnreal +
                ", profitRate=" + profitRate +
                ", leverRate=" + leverRate +
                ", positionMargin=" + positionMargin +
                ", direction='" + direction + '\'' +
                ", profit=" + profit +
                ", lastPrice=" + lastPrice +
                '}';
    }
}
