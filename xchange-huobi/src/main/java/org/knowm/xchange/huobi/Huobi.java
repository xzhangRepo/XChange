package org.knowm.xchange.huobi;

import java.io.IOException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.huobi.dto.account.HuobiCreateWithdrawRequest;
import org.knowm.xchange.huobi.dto.account.HuobiLinearSwapCrossAccount;
import org.knowm.xchange.huobi.dto.account.results.*;
import org.knowm.xchange.huobi.dto.marketdata.results.*;
import org.knowm.xchange.huobi.dto.trade.*;
import org.knowm.xchange.huobi.dto.trade.results.*;
import si.mazi.rescu.ParamsDigest;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface Huobi {

  @GET
  @Path("market/detail/merged")
  HuobiTickerResult getTicker(@QueryParam("symbol") String symbol) throws IOException;

  @GET
  @Path("market/tickers")
  HuobiAllTickersResult getAllTickers() throws IOException;

  @GET
  @Path("market/depth")
  HuobiDepthResult getDepth(@QueryParam("symbol") String symbol, @QueryParam("type") String type)
      throws IOException;

  @GET
  @Path("market/history/trade")
  HuobiTradesResult getTrades(@QueryParam("symbol") String symbol, @QueryParam("size") int size)
      throws IOException;

  @GET
  @Path("v1/common/symbols")
  HuobiAssetPairsResult getAssetPairs() throws IOException;

  @GET
  @Path("v1/common/currencys")
  HuobiAssetsResult getAssets() throws IOException;

  @GET
  @Path("v1/fee/fee-rate/get")
  HuobiFeeRateResult getFeeRate(
      @QueryParam("symbols") String symbols,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v2/reference/transact-fee-rate")
  HuobiTransactFeeRateResult getTransactFeeRate(
      @QueryParam("symbols") String symbols,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/dw/deposit-virtual/addresses")
  HuobiDepositAddressResult getDepositAddress(
      @QueryParam("currency") String currency,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v2/account/deposit/address")
  HuobiDepositAddressV2Result getDepositAddressV2(
      @QueryParam("currency") String currency,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/query/deposit-withdraw")
  HuobiFundingHistoryResult getFundingHistory(
      @QueryParam("currency") String currency,
      @QueryParam("type") String type,
      @QueryParam("from") String from,
      @QueryParam("size") String size,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/dw/deposit-virtual/sharedAddressWithTag")
  HuobiDepositAddressWithTagResult getDepositAddressWithTag(
      @QueryParam("currency") String currency,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @POST
  @Path("v1/dw/withdraw/api/create")
  @Consumes(MediaType.APPLICATION_JSON)
  HuobiCreateWithdrawResult createWithdraw(
      HuobiCreateWithdrawRequest body,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/dw/withdraw-virtual/fee-range")
  @Consumes(MediaType.APPLICATION_JSON)
  HuobiWithdrawFeeRangeResult getWithdrawFeeRange(
      @QueryParam("currency") String currency,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/account/accounts")
  HuobiAccountResult getAccount(
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;



  @GET
  @Path("v1/account/accounts/{account-id}/balance")
  HuobiBalanceResult getBalance(
      @PathParam("account-id") String accountID,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/order/openOrders")
  HuobiOrdersResult getOpenOrders(
      @QueryParam("symbol") String symbol,
      @QueryParam("states") String states,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/order/orders")
  HuobiOrdersResult getOrders(
      @QueryParam("symbol") String symbol,
      @QueryParam("states") String states,
      @QueryParam("start-time") Long startTime,
      @QueryParam("end-time") Long endTime,
      @QueryParam("start-date") String startDate,
      @QueryParam("end-date") String endDate,
      @QueryParam("from") String from,
      @QueryParam("direct") String direct,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/order/history")
  HuobiOrdersResult getOrdersHistory(
      @QueryParam("symbol") String symbol,
      @QueryParam("start-time") Long startTime,
      @QueryParam("end-time") Long endTime,
      @QueryParam("direct") String direct,
      @QueryParam("size") Integer size,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/order/orders/{order-id}")
  HuobiOrderInfoResult getOrder(
      @PathParam("order-id") String orderID,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @GET
  @Path("v1/order/matchresults")
  HuobiMatchesResult getMatchResults(
      @QueryParam("symbol") String symbol,
      @QueryParam("types") String types,
      @QueryParam("start-date") String startDate,
      @QueryParam("end-date") String endDate,
      @QueryParam("from") String from,
      @QueryParam("direct") String direct,
      @QueryParam("size") Integer size,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @POST
  @Path("v1/order/orders/{order-id}/submitcancel")
  HuobiCancelOrderResult cancelOrder(
      @PathParam("order-id") String orderID,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @POST
  @Path("v1/order/orders/place")
  @Consumes(MediaType.APPLICATION_JSON)
  HuobiOrderResult placeLimitOrder(
      HuobiCreateOrderRequest body,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @POST
  @Path("v1/order/orders/place")
  @Consumes(MediaType.APPLICATION_JSON)
  HuobiOrderResult placeMarketOrder(
      HuobiCreateOrderRequest body,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

//  **************交割合约**********************
  @POST
  @Path("api/v1/contract_account_info")
  HuobiFutureAccountResult getContractAccountInfo(
        @QueryParam("symbol") String symbol,
        @QueryParam("AccessKeyId") String apiKey,
        @QueryParam("SignatureMethod") String signatureMethod,
        @QueryParam("SignatureVersion") int SignatureVersion,
        @QueryParam("Timestamp") String nonce,
        @QueryParam("Signature") ParamsDigest signature)
        throws IOException;

  @POST
  @Path("api/v1/contract_position_info")
  HuobiFuturePositionInfoResult getContractPositionInfo(
          @QueryParam("symbol") String symbol,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @POST
  @Path("v1/futures/transfer")
  @Consumes(MediaType.APPLICATION_JSON)
  HuobiFutureTransferResult futuresTransfer(
          FutureTransferRequest request,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @POST
  @Path("api/v1/contract_order")
  @Consumes(MediaType.APPLICATION_JSON)
  FutureOrderResult futuresOrder(
          FutureOrderRequest request,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @POST
  @Path("v2/account/transfer")
  @Consumes(MediaType.APPLICATION_JSON)
  HuobiSwapTransferResult swapTransfer(
          SwapTransferRequest request,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  //交割合约 - 获取合约信息
  @GET
  @Path("api/v1/contract_contract_info")
  ContractContractInfoResult getContractContractInfo(@QueryParam("symbol") String symbol,
                                                     @QueryParam("contract_type") String contractType,
                                                     @QueryParam("contract_code") String contractCode)
          throws IOException;

  //交割合约聚合数据
  @GET
  @Path("market/detail/merged")
  MarketDetailMergedResult getMarketDetailMerged(@QueryParam("symbol") String symbol)
          throws IOException;


  //  **************永续币本位合约**********************
  @POST
  @Path("swap-api/v1/swap_account_info")
  HuobiSwapAccountResult getSwapAccountInfo(
          @QueryParam("contract_code") String contractCode,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @GET
  @Path("swap-api/v1/swap_contract_info")
  SwapContractInfoResult getSwapContractInfo(
          @QueryParam("contract_code") String contractCode)
          throws IOException;


  /**
   * 特指币本位合约
   * @param contractCode
   * @param apiKey
   * @param signatureMethod
   * @param SignatureVersion
   * @param nonce
   * @param signature
   * @return
   * @throws IOException
   */
  @POST
  @Path("swap-api/v1/swap_position_info")
  HuobiSwapPositionResult getSwapPositionInfo(
          @QueryParam("contract_code") String contractCode,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @GET
  @Path("swap-ex/market/detail/batch_merged")
  SwapMarketDetailMergedResult getSwapMarketDetailMerged(@QueryParam("contract_code") String contractCode)
          throws IOException;

  @POST
  @Path("swap-api/v1/swap_order")
  @Consumes(MediaType.APPLICATION_JSON)
  SwapOrderResult swapOrder(
          SwapOrderRequest request,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  //  **************永续U本位逐仓合约**********************
  @POST
  @Path("linear-swap-api/v1/swap_account_info")
  HuobiLinearSwapAccountResult getLinearSwapAccountInfo(
          @QueryParam("contract_code") String contractCode,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @GET
  @Path("linear-swap-ex/market/detail/batch_merged")
  SwapMarketDetailMergedResult getLinearSwapMarketDetailMerged(@QueryParam("contract_code") String contractCode)
          throws IOException;

  //  **************永续U本位全仓合约**********************
  @POST
  @Path("linear-swap-api/v1/swap_cross_account_info")
  HuobiLinearSwapCrossAccountResult getLinearSwapCrossAccountInfo(
          @QueryParam("margin_account") String contractCode,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @POST
  @Path("linear-swap-api/v1/swap_cross_position_info")
  HuobiSwapPositionResult getLinearSwapCrossPositionInfo(
          @QueryParam("contract_code") String contractCode,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  /**
   * 【全仓】合约下单
   * @param request
   * @param apiKey
   * @param signatureMethod
   * @param SignatureVersion
   * @param nonce
   * @param signature
   * @return
   * @throws IOException
   */
  @POST
  @Path("linear-swap-api/v1/swap_cross_order")
  @Consumes(MediaType.APPLICATION_JSON)
  SwapOrderResult linearSwapCrossOrder(
          SwapOrderRequest request,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  /**
   * 【逐仓】合约下单
   * @param request
   * @param apiKey
   * @param signatureMethod
   * @param SignatureVersion
   * @param nonce
   * @param signature
   * @return
   * @throws IOException
   */
  @POST
  @Path("linear-swap-api/v1/swap_order")
  @Consumes(MediaType.APPLICATION_JSON)
  SwapOrderResult linearSwapOrder(
          SwapOrderRequest request,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

  @GET
  @Path("linear-swap-api/v1/swap_contract_info")
  SwapContractInfoResult getLinearSwapContractInfo(
          @QueryParam("contract_code") String contractCode,
          @QueryParam("support_margin_mode") String supportMarginMode)
          throws IOException;

  @GET
  @Path("swap-api/v1/swap_batch_funding_rate")
  FundingRateResult getFundingRate(
          @QueryParam("contract_code") String contractCode)
          throws IOException;

  @GET
  @Path("linear-swap-api/v1/swap_batch_funding_rate")
  FundingRateResult getLinearFundingRate(
          @QueryParam("contract_code") String contractCode)
          throws IOException;

  /**
   * 特指币本位合约
   * @param contractCode
   * @param apiKey
   * @param signatureMethod
   * @param SignatureVersion
   * @param nonce
   * @param signature
   * @return
   * @throws IOException
   */
  @POST
  @Path("linear-swap-api/v1/swap_position_info")
  HuobiSwapPositionResult getLinearSwapPositionInfo(
          @QueryParam("contract_code") String contractCode,
          @QueryParam("AccessKeyId") String apiKey,
          @QueryParam("SignatureMethod") String signatureMethod,
          @QueryParam("SignatureVersion") int SignatureVersion,
          @QueryParam("Timestamp") String nonce,
          @QueryParam("Signature") ParamsDigest signature)
          throws IOException;

}
