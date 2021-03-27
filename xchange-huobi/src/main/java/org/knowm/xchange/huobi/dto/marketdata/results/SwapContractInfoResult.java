package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.SwapContractInfo;

public class SwapContractInfoResult extends HuobiResultV3<SwapContractInfo[]> {

    public SwapContractInfoResult(
            @JsonProperty("status") String status,
            @JsonProperty("data") SwapContractInfo[] result,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, result);
    }

}
