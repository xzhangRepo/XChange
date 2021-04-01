package org.knowm.xchange.okcoin.v5.dto.account;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AccountBalance {

    private String uTime;
    private BigDecimal totalEq;
    private BigDecimal adjEq;
    private BigDecimal isoEq;
    private BigDecimal imr;
    private BigDecimal mmr;
    private BigDecimal mgnRatio;
    private List<Details> details;
    @Data
    public static class Details {
        private BigDecimal availBal;
        private BigDecimal availEq;
        private String ccy;
        private BigDecimal disEq;
        private BigDecimal eq;
        private BigDecimal frozenBal;
        private BigDecimal interest;
        private BigDecimal isoEq;
        private BigDecimal liab;
        private BigDecimal mgnRatio;
        private BigDecimal ordFrozen;
        private BigDecimal upl;
        private BigDecimal uplLiab;
    }
}
