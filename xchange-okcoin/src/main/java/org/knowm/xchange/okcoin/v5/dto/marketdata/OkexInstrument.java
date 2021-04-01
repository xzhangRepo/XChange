package org.knowm.xchange.okcoin.v5.dto.marketdata;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OkexInstrument {
    private String instType;
    private String instId;
    private String uly;
    private int category;
    private String baseCcy;
    private String quoteCcy;
    private String settleCcy;
    private BigDecimal ctVal;
    private BigDecimal ctMult;
    private String ctValCcy;
    private String optType;
    private BigDecimal stk;
    private String listTime;
    private String expTime;
    private BigDecimal lever;
    private BigDecimal tickSz;
    private BigDecimal lotSz;
    private BigDecimal minSz;
    private String ctType;
    private String alias;
    private String state;
}
