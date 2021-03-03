package org.knowm.xchange.huobi;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.huobi.service.HuobiAccountService;
import org.knowm.xchange.huobi.service.HuobiMarketDataService;
import org.knowm.xchange.huobi.service.HuobiTradeService;

import java.io.IOException;

public class HuobiFutureExchange extends BaseExchange implements Exchange {

  @Override
  protected void initServices() {
    this.marketDataService = new HuobiMarketDataService(this);
    this.tradeService = new HuobiTradeService(this);
    this.accountService = new HuobiAccountService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {
    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass());
    exchangeSpecification.setSslUri("https://api.hbdm.com");
    exchangeSpecification.setHost("api.hbdm.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("HuobiFuture");
    exchangeSpecification.setExchangeDescription(
        "HuobiFuture is a Chinese digital currency trading platform and exchange based in Beijing");
    return exchangeSpecification;
  }

  @Override
  public void remoteInit() throws IOException, ExchangeException {
//    HuobiAssetPair[] assetPairs =
//        ((HuobiMarketDataServiceRaw) marketDataService).getHuobiAssetPairs();
//    HuobiAsset[] assets = ((HuobiMarketDataServiceRaw) marketDataService).getHuobiAssets();
//
//    exchangeMetaData = HuobiAdapters.adaptToExchangeMetaData(assetPairs, assets, exchangeMetaData);
  }
}
