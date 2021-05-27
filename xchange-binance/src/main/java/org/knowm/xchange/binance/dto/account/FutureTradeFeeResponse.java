package org.knowm.xchange.binance.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FutureTradeFeeResponse {

    private String symbol;
    private BigDecimal makerCommissionRate;
    private BigDecimal takerCommissionRate;


}
