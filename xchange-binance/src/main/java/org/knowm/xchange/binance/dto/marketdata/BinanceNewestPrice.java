package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BinanceNewestPrice {

    public BinanceNewestPrice(
            @JsonProperty("symbol")String symbol,
            @JsonProperty("ps")String ps,
            @JsonProperty("price")BigDecimal price,
            @JsonProperty("time")long time) {
        this.symbol = symbol;
        this.ps = ps;
        this.price = price;
        this.time = time;
    }
    private String symbol;
    private String ps;
    private BigDecimal price;
    private long time;



}
