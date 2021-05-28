package org.knowm.xchange.binance.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PositionRiskInfo {

    private String symbol;//交易对
    private BigDecimal positionAmt;//头寸数量,符号代表多空方向, 正数为多,负数为空
    private BigDecimal entryPrice;//开仓均价
    private BigDecimal markPrice; //  当前标记价格
    private BigDecimal  unRealizedProfit; // 持仓未实现盈亏
    private BigDecimal liquidationPrice; //  参考强平价格
    private BigDecimal leverage; // 当前杠杆倍数
    private BigDecimal maxQty; // 当前杠杆倍数允许的数量上限(标的数量)
    private String marginType; //逐仓模式或全仓模式
    private BigDecimal isolatedMargin; //逐仓保证金
    private boolean isAutoAddMargin; //
    private String positionSide; //持仓方向

}
