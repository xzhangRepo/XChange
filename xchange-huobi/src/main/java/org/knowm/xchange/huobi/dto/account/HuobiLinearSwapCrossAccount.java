package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class HuobiLinearSwapCrossAccount {

    private String marginMode;
    private String marginAccount;
    private String marginAsset;
    private BigDecimal marginBalance;
    private BigDecimal marginStatic;
    private BigDecimal marginPosition;
    private BigDecimal marginFrozen;
    private BigDecimal profitReal;
    private BigDecimal profitUnreal;
    private BigDecimal withdrawAvailable;
    private BigDecimal riskRate;
    private List<String> contractDetail;

    public HuobiLinearSwapCrossAccount(
            @JsonProperty("margin_mode")String marginMode,
            @JsonProperty("margin_account")String marginAccount,
            @JsonProperty("margin_asset")String marginAsset,
            @JsonProperty("margin_balance")BigDecimal marginBalance,
            @JsonProperty("margin_static")BigDecimal marginStatic,
            @JsonProperty("margin_position")BigDecimal marginPosition,
            @JsonProperty("margin_frozen")BigDecimal marginFrozen,
            @JsonProperty("profit_real")BigDecimal profitReal,
            @JsonProperty("profit_unreal")BigDecimal profitUnreal,
            @JsonProperty("withdraw_available")BigDecimal withdrawAvailable,
            @JsonProperty("risk_rate")BigDecimal riskRate,
            @JsonProperty("contract_detail")List<String> contractDetail) {
        this.marginMode = marginMode;
        this.marginAccount = marginAccount;
        this.marginAsset = marginAsset;
        this.marginBalance = marginBalance;
        this.marginStatic = marginStatic;
        this.marginPosition = marginPosition;
        this.marginFrozen = marginFrozen;
        this.profitReal = profitReal;
        this.profitUnreal = profitUnreal;
        this.withdrawAvailable = withdrawAvailable;
        this.riskRate = riskRate;
        this.contractDetail = contractDetail;
    }

    public String getMarginMode() {
        return marginMode;
    }

    public void setMarginMode(String marginMode) {
        this.marginMode = marginMode;
    }

    public String getMarginAccount() {
        return marginAccount;
    }

    public void setMarginAccount(String marginAccount) {
        this.marginAccount = marginAccount;
    }

    public String getMarginAsset() {
        return marginAsset;
    }

    public void setMarginAsset(String marginAsset) {
        this.marginAsset = marginAsset;
    }

    public BigDecimal getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(BigDecimal marginBalance) {
        this.marginBalance = marginBalance;
    }

    public BigDecimal getMarginStatic() {
        return marginStatic;
    }

    public void setMarginStatic(BigDecimal marginStatic) {
        this.marginStatic = marginStatic;
    }

    public BigDecimal getMarginPosition() {
        return marginPosition;
    }

    public void setMarginPosition(BigDecimal marginPosition) {
        this.marginPosition = marginPosition;
    }

    public BigDecimal getMarginFrozen() {
        return marginFrozen;
    }

    public void setMarginFrozen(BigDecimal marginFrozen) {
        this.marginFrozen = marginFrozen;
    }

    public BigDecimal getProfitReal() {
        return profitReal;
    }

    public void setProfitReal(BigDecimal profitReal) {
        this.profitReal = profitReal;
    }

    public BigDecimal getProfitUnreal() {
        return profitUnreal;
    }

    public void setProfitUnreal(BigDecimal profitUnreal) {
        this.profitUnreal = profitUnreal;
    }

    public BigDecimal getWithdrawAvailable() {
        return withdrawAvailable;
    }

    public void setWithdrawAvailable(BigDecimal withdrawAvailable) {
        this.withdrawAvailable = withdrawAvailable;
    }

    public BigDecimal getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(BigDecimal riskRate) {
        this.riskRate = riskRate;
    }

    public List<String> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<String> contractDetail) {
        this.contractDetail = contractDetail;
    }

    @Override
    public String toString() {
        return "HuobiLinearSwapCrossAccount{" +
                "marginMode='" + marginMode + '\'' +
                ", marginAccount='" + marginAccount + '\'' +
                ", marginAsset='" + marginAsset + '\'' +
                ", marginBalance=" + marginBalance +
                ", marginStatic=" + marginStatic +
                ", marginPosition=" + marginPosition +
                ", marginFrozen=" + marginFrozen +
                ", profitReal=" + profitReal +
                ", profitUnreal=" + profitUnreal +
                ", withdrawAvailable=" + withdrawAvailable +
                ", riskRate=" + riskRate +
                ", contractDetail=" + contractDetail +
                '}';
    }
}
