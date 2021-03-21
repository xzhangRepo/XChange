package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResult;
import org.knowm.xchange.huobi.dto.HuobiResultV3;

public class HuobiFutureTransferResult extends HuobiResult<String> {

    public HuobiFutureTransferResult(
            @JsonProperty("status") String status,
            @JsonProperty("err-code") String errCode,
            @JsonProperty("err-msg") String errMsg,
            @JsonProperty("data") String result
    ) {
        super(status,errCode, errMsg,result);
    }
}