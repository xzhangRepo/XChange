package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class SwapMarketDetailMerged {

    private String contractCode;
    private BigDecimal amount;
    private BigDecimal close;
    private BigDecimal count;
    private BigDecimal high;
    private Integer id;
    private BigDecimal low;
    private BigDecimal open;
    private Long ts;
    private BigDecimal vol;
    private List<BigDecimal> ask;
    private List<BigDecimal> bid;

    public SwapMarketDetailMerged(
            @JsonProperty("contract_code")String contractCode,
            @JsonProperty("amount")BigDecimal amount,
            @JsonProperty("close")BigDecimal close,
            @JsonProperty("count") BigDecimal count,
            @JsonProperty("high")   BigDecimal high,
            @JsonProperty("id") Integer id,
            @JsonProperty("low")  BigDecimal low,
            @JsonProperty("open")  BigDecimal open,
            @JsonProperty("ts")  Long ts,
            @JsonProperty("vol")  BigDecimal vol,
            @JsonProperty("ask")  List<BigDecimal> ask,
            @JsonProperty("bid")List<BigDecimal> bid) {
        this.contractCode = contractCode;
        this.amount = amount;
        this.close = close;
        this.count = count;
        this.high = high;
        this.id = id;
        this.low = low;
        this.open = open;
        this.ts = ts;
        this.vol = vol;
        this.ask = ask;
        this.bid = bid;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public List<BigDecimal> getAsk() {
        return ask;
    }

    public void setAsk(List<BigDecimal> ask) {
        this.ask = ask;
    }

    public List<BigDecimal> getBid() {
        return bid;
    }

    public void setBid(List<BigDecimal> bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "SwapMarketDetailMerged{" +
                "contractCode='" + contractCode + '\'' +
                ", amount=" + amount +
                ", close=" + close +
                ", count=" + count +
                ", high=" + high +
                ", id=" + id +
                ", low=" + low +
                ", open=" + open +
                ", ts=" + ts +
                ", vol=" + vol +
                ", ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
