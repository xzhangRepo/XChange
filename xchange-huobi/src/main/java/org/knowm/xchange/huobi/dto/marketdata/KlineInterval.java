package org.knowm.xchange.huobi.dto.marketdata;

public enum KlineInterval {
//  1min, 5min, 15min, 30min, 60min, 4hour, 1day, 1mon, 1week, 1year
  m1("1m", "1min"),
  m5("5m", "5min"),
  m15("15m", "15min"),
  m30("30m", "30min"),
  h1("1h", "60min"),
  h4("4h", "4hour"),
  d1("1d", "1day"),
  w1("1w", "1week"),
  M1("1M", "1mon");

  private final String code;
  private final String  huobiCode;

  private KlineInterval(String code, String huobiCode) {
    this.huobiCode = huobiCode;
    this.code = code;
  }

  public String getHuobiCode() {
    return huobiCode;
  }

  public String code() {
    return code;
  }

  public static KlineInterval getEnumByCode(String code) {
    for(KlineInterval k: values()) {
      if(k.code().equals(code)) {
        return k;
      }
    }
    return null;
  }

}
