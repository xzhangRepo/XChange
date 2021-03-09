package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.SwapMarketDetailMerged;

public class SwapMarketDetailMergedResult extends HuobiResultV3<SwapMarketDetailMerged[]> {

    public SwapMarketDetailMergedResult(
            @JsonProperty("status") String status,
            @JsonProperty("ticks") SwapMarketDetailMerged[] result,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, result);
    }

}
