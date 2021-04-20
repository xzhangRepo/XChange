package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class ExchangeInfoEntry {

    public ExchangeInfoEntry(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("pair")String pair,
            @JsonProperty("contractType")String contractType,
            @JsonProperty("deliveryDate")Long  deliveryDate,
            @JsonProperty("onboardDate")Long onboardDate,
            @JsonProperty("contractStatus")String contractStatus,
            @JsonProperty("contractSize")Long contractSize,
            @JsonProperty("marginAsset")String marginAsset,
            @JsonProperty("maintMarginPercent")BigDecimal maintMarginPercent,
            @JsonProperty("requiredMarginPercent")BigDecimal requiredMarginPercent,
            @JsonProperty("baseAsset")String baseAsset,
            @JsonProperty("quoteAsset")String quoteAsset,
            @JsonProperty("pricePrecision")Long pricePrecision,
            @JsonProperty("quantityPrecision")Long quantityPrecision,
            @JsonProperty("baseAssetPrecision")Long baseAssetPrecision,
            @JsonProperty("quotePrecision")Long quotePrecision,

            @JsonProperty("equalQtyPrecision")Long equalQtyPrecision,
            @JsonProperty("triggerProtect")Double triggerProtect,
            @JsonProperty("underlyingType")String  underlyingType,

            @JsonProperty("underlyingSubType")List<String>  underlyingSubType,

            @JsonProperty("orderTypes")List<String> orderTypes,
            @JsonProperty("timeInForce")List<String> timeInForce,
            @JsonProperty("filters")List<Map<String, String>> filters) {
        this.symbol = symbol;
        this.pair = pair;
        this.contractType = contractType;
        this.deliveryDate = deliveryDate;
        this.onboardDate = onboardDate;
        this.contractStatus = contractStatus;
        this.contractSize = contractSize;
        this.marginAsset = marginAsset;
        this.maintMarginPercent = maintMarginPercent;
        this.requiredMarginPercent = requiredMarginPercent;
        this.baseAsset = baseAsset;
        this.quoteAsset = quoteAsset;
        this.pricePrecision = pricePrecision;
        this.quantityPrecision = quantityPrecision;
        this.baseAssetPrecision = baseAssetPrecision;
        this.quotePrecision = quotePrecision;
        this.equalQtyPrecision = equalQtyPrecision;
        this.triggerProtect = triggerProtect;
        this.underlyingType = underlyingType;
        this.underlyingSubType = underlyingSubType;
        this.orderTypes = orderTypes;
        this.timeInForce = timeInForce;
        this.filters = filters;
    }

    private String symbol;

    private String pair;

    private String contractType;

    private Long deliveryDate;

    private Long onboardDate;

    private String contractStatus;

    private Long contractSize;

    private String marginAsset;


    private BigDecimal maintMarginPercent;

    private BigDecimal requiredMarginPercent;

    private String baseAsset;

    private String quoteAsset;

    private Long pricePrecision;

    private Long quantityPrecision;

    private Long baseAssetPrecision;

    private Long quotePrecision;

    private Long equalQtyPrecision;
    private Double triggerProtect;
    private String  underlyingType;

    private List<String>  underlyingSubType;

    private List<String> orderTypes;

    private List<String> timeInForce;

    private List<Map<String, String>> filters;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getOnboardDate() {
        return onboardDate;
    }

    public void setOnboardDate(Long onboardDate) {
        this.onboardDate = onboardDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Long getContractSize() {
        return contractSize;
    }

    public void setContractSize(Long contractSize) {
        this.contractSize = contractSize;
    }

    public String getMarginAsset() {
        return marginAsset;
    }

    public void setMarginAsset(String marginAsset) {
        this.marginAsset = marginAsset;
    }

    public BigDecimal getMaintMarginPercent() {
        return maintMarginPercent;
    }

    public void setMaintMarginPercent(BigDecimal maintMarginPercent) {
        this.maintMarginPercent = maintMarginPercent;
    }

    public BigDecimal getRequiredMarginPercent() {
        return requiredMarginPercent;
    }

    public void setRequiredMarginPercent(BigDecimal requiredMarginPercent) {
        this.requiredMarginPercent = requiredMarginPercent;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Long getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Long pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Long getQuantityPrecision() {
        return quantityPrecision;
    }

    public void setQuantityPrecision(Long quantityPrecision) {
        this.quantityPrecision = quantityPrecision;
    }

    public Long getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Long baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public Long getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Long quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public Long getEqualQtyPrecision() {
        return equalQtyPrecision;
    }

    public void setEqualQtyPrecision(Long equalQtyPrecision) {
        this.equalQtyPrecision = equalQtyPrecision;
    }

    public Double getTriggerProtect() {
        return triggerProtect;
    }

    public void setTriggerProtect(Double triggerProtect) {
        this.triggerProtect = triggerProtect;
    }

    public String getUnderlyingType() {
        return underlyingType;
    }

    public void setUnderlyingType(String underlyingType) {
        this.underlyingType = underlyingType;
    }

    public List<String> getUnderlyingSubType() {
        return underlyingSubType;
    }

    public void setUnderlyingSubType(List<String> underlyingSubType) {
        this.underlyingSubType = underlyingSubType;
    }

    public List<String> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<String> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public List<String> getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(List<String> timeInForce) {
        this.timeInForce = timeInForce;
    }

    public List<Map<String, String>> getFilters() {
        return filters;
    }

    public void setFilters(List<Map<String, String>> filters) {
        this.filters = filters;
    }
}
