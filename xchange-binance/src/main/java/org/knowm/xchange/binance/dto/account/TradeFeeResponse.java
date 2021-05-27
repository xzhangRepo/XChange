package org.knowm.xchange.binance.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradeFeeResponse {

    private String symbol;
    private BigDecimal makerCommission;
    private BigDecimal takerCommission;


}
