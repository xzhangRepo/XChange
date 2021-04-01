package org.knowm.xchange.okcoin.v3.service;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.okcoin.OkexExchangeV3;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexFutureInstrument;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexFutureTicker;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSpotInstrument;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSpotTicker;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSwapInstrument;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSwapTicker;
import org.knowm.xchange.okcoin.v5.dto.marketdata.OkexInstrument;

public class OkexMarketDataServiceRaw extends OkexBaseService {

  public OkexMarketDataServiceRaw(OkexExchangeV3 exchange) {
    super(exchange);
  }

  public List<OkexSpotInstrument> getAllSpotInstruments() throws IOException {
    return okex.getAllSpotInstruments();
  }

  public List<OkexSpotTicker> getAllSpotTickers() throws IOException {
    return okex.getAllSpotTickers();
  }

  public OkexSpotTicker getSpotTicker(String instrumentID) throws IOException {
    OkexSpotTicker tokenPairInformation = okex.getSpotTicker(instrumentID);
    return tokenPairInformation;
  }

  public List<OkexFutureInstrument> getAllFutureInstruments() throws IOException {
    return okex.getAllFutureInstruments();
  }

  public List<OkexFutureTicker> getAllFutureTickers() throws IOException {
    return okex.getAllFutureTickers();
  }

  public List<OkexSwapInstrument> getAllSwapInstruments() throws IOException {
    return okex.getAllSwapInstruments();
  }

  public List<OkexSwapTicker> getAllSwapTickers() throws IOException {
    return okex.getAllSwapTickers();
  }

  /**
   *
   * @param instType  SPOT：币币 SWAP：永续合约 FUTURES：交割合约 OPTION：期权
   * @param uly  合约标的指数，仅适用于交割/永续/期权，期权必填
   * @param instId 产品ID
   * @return
   * @throws IOException
   */
  public List<OkexInstrument> getAllInstruments(String instType,String uly,String instId) throws IOException {
    return checkResultV5(okex.getAllInstruments(instType,uly,instId));
  }
}
