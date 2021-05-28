package org.knowm.xchange.binance.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AssetsInfo {
    private String asset;  // 资产名
    private BigDecimal walletBalance; // 账户余额
    private BigDecimal unrealizedProfit; // 全部持仓未实现盈亏
    private BigDecimal marginBalance; // 保证金余额
    private BigDecimal maintMargin; // 维持保证金
    private BigDecimal initialMargin; // 当前所需起始保证金(按最新标标记价格)
    private BigDecimal positionInitialMargin; // 当前所需持仓起始保证金(按最新标标记价格)
    private BigDecimal openOrderInitialMargin; // 当前所需挂单起始保证金(按最新标标记价格)
    private BigDecimal maxWithdrawAmount; // 最大可提款金额
    private BigDecimal crossWalletBalance; // 可用于全仓的账户余额
    private BigDecimal crossUnPnl; // 所有全仓持仓的未实现盈亏
    private BigDecimal availableBalance; // 可用下单余额
}
