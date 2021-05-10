package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.FundingRate;
import org.knowm.xchange.huobi.dto.marketdata.HistoricalFundingRate;
import org.knowm.xchange.huobi.dto.marketdata.HistoricalFundingRateData;

public class HistoricalFundingRateResult extends HuobiResultV3<HistoricalFundingRateData> {

    public HistoricalFundingRateResult(
            @JsonProperty("status") String status,
            @JsonProperty("data") HistoricalFundingRateData data,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, data);
    }
}