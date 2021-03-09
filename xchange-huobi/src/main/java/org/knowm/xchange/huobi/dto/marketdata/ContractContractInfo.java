package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public final  class ContractContractInfo {

    private String symbol;
    private String contractCode;
    private String contractType;
    private Integer contractSize;
    private BigDecimal priceTick;
    private String deliveryDate;
    private String createDate;
    private Integer contractStatus;


    public ContractContractInfo(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("contract_type")String contractType,
            @JsonProperty("contract_size")Integer contractSize,
            @JsonProperty("price_tick")BigDecimal priceTick,
            @JsonProperty("delivery_date")String deliveryDate,
            @JsonProperty("create_date")String createDate,
            @JsonProperty("contract_status")Integer contractStatus) {
        this.symbol = symbol;
        this.contractCode = contractCode;
        this.contractType = contractType;
        this.contractSize = contractSize;
        this.priceTick = priceTick;
        this.deliveryDate = deliveryDate;
        this.createDate = createDate;
        this.contractStatus = contractStatus;
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

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Integer getContractSize() {
        return contractSize;
    }

    public void setContractSize(Integer contractSize) {
        this.contractSize = contractSize;
    }

    public BigDecimal getPriceTick() {
        return priceTick;
    }

    public void setPriceTick(BigDecimal priceTick) {
        this.priceTick = priceTick;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        return "ContractContractInfo{" +
                "symbol='" + symbol + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", contractType='" + contractType + '\'' +
                ", contractSize=" + contractSize +
                ", priceTick=" + priceTick +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", createDate='" + createDate + '\'' +
                ", contractStatus=" + contractStatus +
                '}';
    }
}
