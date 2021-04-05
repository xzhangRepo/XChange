package org.knowm.xchange.okcoin.v5.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountPosition {

    private String instId;
    private String instType;
    private String mgnMode;
    private String posId;
    private String posSide;
    private BigDecimal pos;
    private String ccy;
    private String posCcy;
    private BigDecimal availPos;
    private BigDecimal avgPx;
    private BigDecimal upl;
    private BigDecimal uplRatio;
    private BigDecimal lever;
    private BigDecimal liqPx;
    private BigDecimal imr;
    private BigDecimal margin;
    private BigDecimal mgnRatio;
    private BigDecimal mmr;
    private BigDecimal liab;
    private String liabCcy;
    private BigDecimal interest;
    private String tradeId;
    private BigDecimal optVal;
    private BigDecimal adl;
    private BigDecimal last;
    private long cTime;
    private long uTime;
}
