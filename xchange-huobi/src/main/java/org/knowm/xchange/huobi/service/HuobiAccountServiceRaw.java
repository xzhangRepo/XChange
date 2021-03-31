package org.knowm.xchange.huobi.service;

import java.io.IOException;
import java.math.BigDecimal;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.huobi.HuobiUtils;
import org.knowm.xchange.huobi.dto.account.*;
import org.knowm.xchange.huobi.dto.account.results.*;
import org.knowm.xchange.huobi.dto.trade.FutureTransferRequest;
import org.knowm.xchange.huobi.dto.trade.SwapTransferRequest;

public class HuobiAccountServiceRaw extends HuobiBaseService {
  private HuobiAccount[] accountCache = null;

  HuobiAccountServiceRaw(Exchange exchange) {
    super(exchange);
  }

  HuobiBalance getHuobiBalance(String accountID) throws IOException {
    HuobiBalanceResult huobiBalanceResult =
        huobi.getBalance(
            accountID,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(huobiBalanceResult);
  }

  public HuobiAccount[] getAccounts() throws IOException {
    if (accountCache == null) {
      HuobiAccountResult huobiAccountResult =
          huobi.getAccount(
              exchange.getExchangeSpecification().getApiKey(),
              HuobiDigest.HMAC_SHA_256,
              2,
              HuobiUtils.createUTCDate(exchange.getNonceFactory()),
              signatureCreator);
      accountCache = checkResult(huobiAccountResult);
    }

    return accountCache;
  }

  public HuobiFeeRate[] getFeeRate(String symbols) throws IOException {
    HuobiFeeRateResult transactFeeRateResult =
        huobi.getFeeRate(
            symbols.toLowerCase(),
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(transactFeeRateResult);
  }

  public HuobiTransactFeeRate[] getTransactFeeRate(String currency) throws IOException {
    HuobiTransactFeeRateResult transactFeeRateResult =
        huobi.getTransactFeeRate(
            currency.toLowerCase(),
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(transactFeeRateResult);
  }

  public String getDepositAddress(String currency) throws IOException {
    HuobiDepositAddressResult depositAddressResult =
        huobi.getDepositAddress(
            currency.toLowerCase(),
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(depositAddressResult);
  }

  public HuobiDepositAddress[] getDepositAddressV2(String currency) throws IOException {
    HuobiDepositAddressV2Result depositAddressResult =
        huobi.getDepositAddressV2(
            currency != null ? currency.toLowerCase() : null,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(depositAddressResult);
  }

  public HuobiDepositAddressWithTag getDepositAddressWithTag(String currency) throws IOException {
    HuobiDepositAddressWithTagResult depositAddressWithTagResult =
        huobi.getDepositAddressWithTag(
            currency.toLowerCase(),
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(depositAddressWithTagResult);
  }

  public HuobiFundingRecord[] getDepositWithdrawalHistory(String currency, String type, String from)
      throws IOException {
    HuobiFundingHistoryResult fundingHistoryResult =
        huobi.getFundingHistory(
            currency != null ? currency.toLowerCase() : null,
            type.toLowerCase(),
            from,
            "100",
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(fundingHistoryResult);
  }

  public HuobiWithdrawFeeRange getWithdrawFeeRange(String currency) throws IOException {
    HuobiWithdrawFeeRangeResult result =
        huobi.getWithdrawFeeRange(
            currency.toLowerCase(),
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(result);
  }

  public long createWithdraw(
      String currency, BigDecimal amount, BigDecimal fee, String address, String addressTag)
      throws IOException {
    HuobiCreateWithdrawRequest createWithdrawRequest =
        new HuobiCreateWithdrawRequest(address, amount, currency.toLowerCase(), fee, addressTag);
    HuobiCreateWithdrawResult createWithdrawResult =
        huobi.createWithdraw(
            createWithdrawRequest,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(createWithdrawResult);
  }

  //交割合约账户信息
  public HuobiFutureAccount[] getFutureContractAccountInfo(String symbol) throws IOException {
    HuobiFutureAccountResult result = huobi.getContractAccountInfo(
                    symbol,
                    exchange.getExchangeSpecification().getApiKey(),
                    HuobiDigest.HMAC_SHA_256,
                    2,
                    HuobiUtils.createUTCDate(exchange.getNonceFactory()),
                    signatureCreator);
    return checkResultV3(result);
  }

  //持仓信息
  public HuobiFuturePosition[] getFuturePositionInfo(String symbol) throws IOException {
    HuobiFuturePositionInfoResult result = huobi.getContractPositionInfo(
            symbol,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }

  /**
   * 资金划转
   * @param currency
   * @param amount
   * @param type
   * @return
   * @throws IOException
   */
  public String futuresTransfer(String currency,String amount,String type) throws IOException {
    FutureTransferRequest request  = FutureTransferRequest.builder().currency(currency).amount(amount).type(type).build();
    HuobiFutureTransferResult result = huobi.futuresTransfer(
              request,
              exchange.getExchangeSpecification().getApiKey(),
              HuobiDigest.HMAC_SHA_256,
              2,
              HuobiUtils.createUTCDate(exchange.getNonceFactory()),
              signatureCreator);
    return checkResult(result);
  }


  /**
   * 永续合约转币
   * @param from
   * @param to
   * @param currency
   * @param amount
   * @param marginAccount
   * @return
   * @throws IOException
   */
  public String swapTransfer(String from,String to,String currency,BigDecimal amount,String marginAccount) throws IOException {
    SwapTransferRequest request  = SwapTransferRequest.builder().from(from).to(to).currency(currency).amount(amount).marginAccount(marginAccount).build();
    HuobiSwapTransferResult result = huobi.swapTransfer(
            request,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResult(result);
  }
  //永续合约账户信息
  public HuobiSwapAccount[] getSwapContractAccountInfo(String contractCode) throws IOException {
    HuobiSwapAccountResult result = huobi.getSwapAccountInfo(
            contractCode,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }

  //永续合约持仓信息
  public HuobiSwapPosition[] getSwapPositionInfo(String contractCode) throws IOException {
    HuobiSwapPositionResult result = huobi.getSwapPositionInfo(
            contractCode,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }

  //永续合约账户信息
  public HuobiLinearSwapAccount[] getLinearSwapContractAccountInfo(String contractCode) throws IOException {
    HuobiLinearSwapAccountResult result = huobi.getLinearSwapAccountInfo(
            contractCode,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }


  //永续合约账户信息
  public HuobiLinearSwapCrossAccount[] getLinearSwapCrossContractAccountInfo(String contractCode) throws IOException {
    HuobiLinearSwapCrossAccountResult result = huobi.getLinearSwapCrossAccountInfo(
            contractCode,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }

  //永续合约u本位持仓信息（全仓信息）
  public HuobiSwapPosition[] getLinearSwapCrossPositionInfo(String contractCode) throws IOException {
    HuobiSwapPositionResult result = huobi.getLinearSwapCrossPositionInfo(
            contractCode,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }

  //永续合约u本位持仓信息（逐仓信息）
  public HuobiSwapPosition[] getLinearSwapPositionInfo(String contractCode) throws IOException {
    HuobiSwapPositionResult result = huobi.getLinearSwapPositionInfo(
            contractCode,
            exchange.getExchangeSpecification().getApiKey(),
            HuobiDigest.HMAC_SHA_256,
            2,
            HuobiUtils.createUTCDate(exchange.getNonceFactory()),
            signatureCreator);
    return checkResultV3(result);
  }
}
