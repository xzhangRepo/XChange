package org.knowm.xchange.binance.dto.account;

import lombok.Data;

import java.util.List;

@Data
public class AccountInfo {

    private List<AssetsInfo> assets;

    private List<PositionInfo> positions;
    private  boolean canDeposit;// 是否可以入金
    private  boolean canTrade;// 是否可以交易
    private  boolean canWithdraw;// 是否可以出金
    private  int feeTier;//手续费等级
    private  long updateTime;


}
