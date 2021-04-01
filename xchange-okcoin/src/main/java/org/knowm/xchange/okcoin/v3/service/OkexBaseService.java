package org.knowm.xchange.okcoin.v3.service;

import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.okcoin.OkexDigestV3;
import org.knowm.xchange.okcoin.OkexExchangeV3;
import org.knowm.xchange.okcoin.OkexV3;
import org.knowm.xchange.okcoin.v5.OkexResultV5;
import org.knowm.xchange.okcoin.v5.dto.trade.OrderInfo;
import org.knowm.xchange.okcoin.v5.dto.trade.OrderInfoResult;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;

import java.util.List;

public class OkexBaseService extends BaseExchangeService<OkexExchangeV3> implements BaseService {

  protected final OkexV3 okex;
  protected final String apikey;
  protected final String passphrase;
  protected final OkexDigestV3 digest;

  protected final String tradepwd;

  public OkexBaseService(OkexExchangeV3 exchange) {
    super(exchange);
    final ExchangeSpecification spec = exchange.getExchangeSpecification();
    okex = ExchangeRestProxyBuilder.forInterface(OkexV3.class, spec).build();
    apikey = spec.getApiKey();
    passphrase = (String) spec.getExchangeSpecificParametersItem("passphrase");

    String secretKey = spec.getSecretKey();
    digest = secretKey == null ? null : new OkexDigestV3(secretKey);
    tradepwd = (String) spec.getExchangeSpecificParametersItem("tradepwd");
  }

  protected static String timestamp() {
    return System.currentTimeMillis() / 1000 + ".000"; //          <-- works as well
    // return Instant.now().toString();
  }


  protected <R> R checkResultV5(OkexResultV5<R> okexResult) {
    if (!okexResult.isSuccess()) {
      String okexError = okexResult.getError();
      if (okexError.length() == 0) {
        throw new ExchangeException("Missing error message");
      } else {
        throw new ExchangeException(okexError);
      }
    }
    return okexResult.getResult();
  }

  protected List<OrderInfo> checkResultV5Order(OrderInfoResult orderInfoResult) {
    if (!orderInfoResult.isSuccess()) {
      String okexError = orderInfoResult.getError();
      if (okexError.length() == 0) {
        okexError = orderInfoResult.getResult().get(0).getSMsg();
        throw new ExchangeException(okexError);
      } else {
        throw new ExchangeException(okexError);
      }
    }
    return orderInfoResult.getResult();
  }
}
