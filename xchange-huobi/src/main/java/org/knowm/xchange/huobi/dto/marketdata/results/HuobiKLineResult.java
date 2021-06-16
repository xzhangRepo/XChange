package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResult;
import org.knowm.xchange.huobi.dto.marketdata.HuobiDepth;
import org.knowm.xchange.huobi.dto.marketdata.HuobiKLine;
import org.knowm.xchange.huobi.dto.marketdata.HuobiTicker;

import java.util.Date;
import java.util.List;

public class HuobiKLineResult extends HuobiResult<List<HuobiKLine>> {

  @JsonCreator
  public HuobiKLineResult(
      @JsonProperty("status") String status,
      @JsonProperty("ts") Date ts,
      @JsonProperty("data") List<HuobiKLine> kline,
      @JsonProperty("ch") String ch,
      @JsonProperty("err-code") String errCode,
      @JsonProperty("err-msg") String errMsg) {
    super(status, errCode, errMsg, kline);
  }
}
