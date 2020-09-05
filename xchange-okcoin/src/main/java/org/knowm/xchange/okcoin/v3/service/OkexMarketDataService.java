package org.knowm.xchange.okcoin.v3.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Kline;
import org.knowm.xchange.dto.marketdata.KlineInterval;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.okcoin.OkexAdaptersV3;
import org.knowm.xchange.okcoin.OkexExchangeV3;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexOrderBook;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSpotKLine;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSpotTicker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.marketdata.params.Params;

public class OkexMarketDataService extends OkexMarketDataServiceRaw implements MarketDataService {

  public OkexMarketDataService(OkexExchangeV3 exchange) {
    super(exchange);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
    OkexSpotTicker tokenPairInformation =
        okex.getSpotTicker(OkexAdaptersV3.toSpotInstrument(currencyPair));
    return OkexAdaptersV3.convert(tokenPairInformation);
  }

  @Override
  public List<Ticker> getTickers(Params params) throws IOException {
    return okex.getAllSpotTickers().stream()
        .map(OkexAdaptersV3::convert)
        .collect(Collectors.toList());
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair pair, Object... args) throws IOException {

    int limitDepth = 50;

    if (args != null && args.length == 1) {
      Object arg0 = args[0];
      if (!(arg0 instanceof Integer)) {
        throw new IllegalArgumentException("Argument 0 must be an Integer!");
      } else {
        limitDepth = (Integer) arg0;
      }
    }
    OkexOrderBook okexOrderbook =
        okex.getOrderBook(OkexAdaptersV3.toSpotInstrument(pair), limitDepth);
    return OkexAdaptersV3.convertOrderBook(okexOrderbook, pair);
  }

  @Override
  public List<Kline> getKlines(CurrencyPair pair, KlineInterval interval) throws IOException{
   List<OkexSpotKLine>  okexKlines = okex.getKLine(OkexAdaptersV3.toSpotInstrument(pair),interval.getMillis()/1000);
   okexKlines.forEach(okexSpotKLine -> {okexSpotKLine.setInstrumentId(OkexAdaptersV3.toSpotInstrument(pair));});
   Collections.reverse(okexKlines);
   return OkexAdaptersV3.adaptKline(okexKlines);
  }
}
