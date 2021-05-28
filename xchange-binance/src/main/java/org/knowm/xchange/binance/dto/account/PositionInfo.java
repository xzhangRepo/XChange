package org.knowm.xchange.binance.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PositionInfo {

    private String symbol;// 交易对
    private BigDecimal initialMargin; // 当前所需起始保证金(按最新标标记价格)
    private BigDecimal maintMargin; // 持仓维持保证金
    private BigDecimal unrealizedProfit; // 持仓未实现盈亏
    private BigDecimal positionInitialMargin; // 当前所需持仓起始保证金(按最新标标记价格)
    private BigDecimal openOrderInitialMargin; // 当前所需挂单起始保证金(按最新标标记价格)
    private BigDecimal leverage; // 杠杆倍率
    private boolean isolated; // 是否是逐仓模式
    private String positionSide; // 持仓方向
    private BigDecimal entryPrice; // 平均持仓成本
    private BigDecimal maxQty; // 当前杠杆下最大可开仓数(标的数量)
}
