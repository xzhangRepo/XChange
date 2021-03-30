package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.FundingRate;

public class FundingRateResult  extends HuobiResultV3<FundingRate[]> {

    public FundingRateResult(
            @JsonProperty("status") String status,
            @JsonProperty("data") FundingRate[] result,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, result);
    }
}