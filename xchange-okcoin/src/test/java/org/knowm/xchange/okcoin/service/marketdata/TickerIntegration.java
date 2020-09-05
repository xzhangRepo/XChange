package org.knowm.xchange.okcoin.service.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Kline;
import org.knowm.xchange.dto.marketdata.KlineInterval;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.okcoin.OkCoinExchange;
import org.knowm.xchange.okcoin.OkexExchangeV3;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.util.List;
import java.util.Optional;

/** @author timmolter */
public class TickerIntegration {

  @Test
  public void tickerFetchChinaTest() throws Exception {
    ExchangeSpecification exSpec = new ExchangeSpecification(OkexExchangeV3.class);

    exSpec.setExchangeSpecificParametersItem("Use_Intl", false);
    exSpec.setProxyPort(1080);
    exSpec.setProxyHost("127.0.0.1");
    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    MarketDataService marketDataService = exchange.getMarketDataService();
    AccountService xChangeAccountService =  exchange.getAccountService();
    //判断BTC持仓
    xChangeAccountService.getAccountInfo();
    List<Kline> ticker = marketDataService.getKlines(new CurrencyPair("BTC", "USDT"), KlineInterval.m30);
    System.out.println(ticker.toString());
    assertThat(ticker).isNotNull();
  }

  @Test
  public void tickerFetchIntlTest() throws Exception {
    ExchangeSpecification exSpec = new ExchangeSpecification(OkCoinExchange.class);
    exSpec.setExchangeSpecificParametersItem("Use_Intl", true);

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    MarketDataService marketDataService = exchange.getMarketDataService();
    Ticker ticker = marketDataService.getTicker(new CurrencyPair("BTC", "USD"));
    System.out.println(ticker.toString());
    assertThat(ticker).isNotNull();
  }
}
