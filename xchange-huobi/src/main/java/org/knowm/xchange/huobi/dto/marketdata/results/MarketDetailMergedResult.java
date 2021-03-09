package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.MarketDetailMerged;

public class MarketDetailMergedResult extends HuobiResultV3<MarketDetailMerged> {


    public MarketDetailMergedResult(
            @JsonProperty("status") String status,
            @JsonProperty("tick") MarketDetailMerged result,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, result);
    }
}
