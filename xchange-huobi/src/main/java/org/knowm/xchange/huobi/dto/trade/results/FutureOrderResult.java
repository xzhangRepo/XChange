package org.knowm.xchange.huobi.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;


public class FutureOrderResult extends HuobiResultV3<FutureOrderInfo> {


    public FutureOrderResult(
            @JsonProperty("status") String status,
            @JsonProperty("data") FutureOrderInfo result,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, result);
    }
}
