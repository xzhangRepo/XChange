package org.knowm.xchange.okcoin.v5.dto.marketdata;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OkexFundRate {

    private BigDecimal fundingRate;
    private long fundingTime;
    private String instId;
    private String instType;
    private BigDecimal nextFundingRate;
    private String nextFundingTime;
}
