package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SwapContractInfo {

    private String symbol;
    private String contractCode;
    private BigDecimal contractSize;
    private BigDecimal priceTick;
    private String deliveryTime;
    private String createDate;
    private int contractStatus;
    private String settlementDate;

    public SwapContractInfo(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("contract_size")BigDecimal contractSize,
            @JsonProperty("price_tick")BigDecimal priceTick,
            @JsonProperty("delivery_time")String deliveryTime,
            @JsonProperty("create_date")String createDate,
            @JsonProperty("contract_status")int contractStatus,
            @JsonProperty("settlement_date")String settlementDate) {
        this.symbol = symbol;
        this.contractCode = contractCode;
        this.contractSize = contractSize;
        this.priceTick = priceTick;
        this.deliveryTime = deliveryTime;
        this.createDate = createDate;
        this.contractStatus = contractStatus;
        this.settlementDate = settlementDate;
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

    public BigDecimal getContractSize() {
        return contractSize;
    }

    public void setContractSize(BigDecimal contractSize) {
        this.contractSize = contractSize;
    }

    public BigDecimal getPriceTick() {
        return priceTick;
    }

    public void setPriceTick(BigDecimal priceTick) {
        this.priceTick = priceTick;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(int contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }
}
