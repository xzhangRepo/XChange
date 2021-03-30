package org.knowm.xchange.huobi.service;

import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.huobi.HuobiUtils;
import org.knowm.xchange.huobi.dto.marketdata.*;
import org.knowm.xchange.huobi.dto.marketdata.results.*;

import javax.ws.rs.QueryParam;

public class HuobiMarketDataServiceRaw extends HuobiBaseService {

  public HuobiMarketDataServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public HuobiTicker getHuobiTicker(CurrencyPair currencyPair) throws IOException {
    String huobiCurrencyPair = HuobiUtils.createHuobiCurrencyPair(currencyPair);
    HuobiTickerResult tickerResult = huobi.getTicker(huobiCurrencyPair);
    return checkResult(tickerResult);
  }

  public HuobiAllTicker[] getHuobiAllTickers() throws IOException {
    HuobiAllTickersResult allTickerResult = huobi.getAllTickers();
    return checkResult(allTickerResult);
  }

  public HuobiAssetPair[] getHuobiAssetPairs() throws IOException {
    HuobiAssetPairsResult assetPairsResult = huobi.getAssetPairs();
    return checkResult(assetPairsResult);
  }

  public HuobiDepth getHuobiDepth(CurrencyPair currencyPair, String depthType) throws IOException {
    String huobiCurrencyPair = HuobiUtils.createHuobiCurrencyPair(currencyPair);
    HuobiDepthResult depthResult = huobi.getDepth(huobiCurrencyPair, depthType);
    return checkResult(depthResult);
  }

  public HuobiTradeWrapper[] getHuobiTrades(CurrencyPair currencyPair, int size)
      throws IOException {
    String huobiCurrencyPair = HuobiUtils.createHuobiCurrencyPair(currencyPair);
    HuobiTradesResult tradesResult = huobi.getTrades(huobiCurrencyPair, size);
    return checkResult(tradesResult);
  }

  /**
   * 获取交割市场信息
   * @param symbol
   * @param contractType
   * @param contractCode
   * @return
   * @throws IOException
   */
  public ContractContractInfo[] getContractContractInfo(String symbol,String contractType,String contractCode)throws IOException{
    ContractContractInfoResult contractResult = huobi.getContractContractInfo(symbol,contractType,contractCode);
    return checkResultV3(contractResult);
  }
  /**
   * 获取交割聚合行情数据
   */
  public MarketDetailMerged getMarketDetailMerged(String symbol) throws IOException {
    MarketDetailMergedResult result = huobi.getMarketDetailMerged(symbol);
    return checkResultV3(result);
  }

  /**
   * 永续合约批量聚合数据币本位
   */
  public SwapMarketDetailMerged[] getSwapMarketDetailMerged(String contractCode) throws IOException {
    SwapMarketDetailMergedResult result = huobi.getSwapMarketDetailMerged(contractCode);
    return checkResultV3(result);
  }

  /**
   * 获取永续合约信息
   * @param contractCode
   * @return
   * @throws IOException
   */
  public SwapContractInfo[] getSwapContractInfo(String contractCode)throws IOException{
    SwapContractInfoResult contractResult = huobi.getSwapContractInfo(contractCode);
    return checkResultV3(contractResult);
  }

  /**
   * 永续合约批量聚合数据U本位
   */
  public SwapMarketDetailMerged[] getLinearSwapMarketDetailMerged(String contractCode) throws IOException {
    SwapMarketDetailMergedResult result = huobi.getLinearSwapMarketDetailMerged(contractCode);
    return checkResultV3(result);
  }

  /**
   * 获取U本位永续合约信息
   * @param contractCode
   * @return
   * @throws IOException
   */
  public SwapContractInfo[] getLinearSwapContractInfo(String contractCode,String supportMarginMode)throws IOException{
    SwapContractInfoResult contractResult = huobi.getLinearSwapContractInfo(contractCode,supportMarginMode);
    return checkResultV3(contractResult);
  }

  /**
   * 资金费率
   * @param contractCode
   * @return
   * @throws IOException
   */
  public FundingRate[] getFundingRate(String contractCode) throws IOException {
    FundingRateResult fundingRateResult = huobi.getFundingRate(contractCode);
    return checkResultV3(fundingRateResult);
  }

  /**
   * 资金费率
   * @param contractCode
   * @return
   * @throws IOException
   */
  public FundingRate[] getLinearFundingRate(String contractCode) throws IOException {
    FundingRateResult fundingRateResult = huobi.getLinearFundingRate(contractCode);
    return checkResultV3(fundingRateResult);
  }
}
