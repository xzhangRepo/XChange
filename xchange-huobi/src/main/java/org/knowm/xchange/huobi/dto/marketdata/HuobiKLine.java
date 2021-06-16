package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public final class HuobiKLine {

    @JsonIgnore
    private String instrumentId;
    private final long id;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal low;
    private final BigDecimal high;
    private final BigDecimal amount;
    private final BigDecimal vol;
    private final long count;

    public HuobiKLine(
        @JsonProperty("id") long id,
        @JsonProperty("open") BigDecimal open,
        @JsonProperty("close") BigDecimal close,
        @JsonProperty("low") BigDecimal low,
        @JsonProperty("high") BigDecimal high,
        @JsonProperty("amount") BigDecimal amount,
        @JsonProperty("vol") BigDecimal vol,
        @JsonProperty("count") long count) {
      this.id = id;
      this.amount = amount;
      this.open = open;
      this.close = close;
      this.low = low;
      this.high = high;
      this.vol = vol;
      this.count = count;
    }

    public long getId() {
      return id*1000;
    }

    public BigDecimal getOpen() {
      return open;
    }

    public BigDecimal getClose() {
      return close;
    }

    public BigDecimal getLow() {
      return low;
    }

    public BigDecimal getHigh() {
      return high;
    }

    public BigDecimal getAmount() {
      return amount;
    }

    public BigDecimal getVol() {
      return vol;
    }

    public long getCount() {
      return count;
    }

    public String getInstrumentId() {
      return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
      this.instrumentId = instrumentId;
    }

    @Override
    public String toString() {
      return "HuobiKLine{" +
              "instrumentId='" + instrumentId + '\'' +
              ", id=" + id +
              ", open=" + open +
              ", close=" + close +
              ", low=" + low +
              ", high=" + high +
              ", amount=" + amount +
              ", vol=" + vol +
              ", count=" + count +
              '}';
    }
}
