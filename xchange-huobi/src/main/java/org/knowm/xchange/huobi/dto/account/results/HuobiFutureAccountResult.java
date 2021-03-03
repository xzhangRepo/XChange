package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiFutureAccount;

public class HuobiFutureAccountResult  extends HuobiResultV3<HuobiFutureAccount[]> {

    public HuobiFutureAccountResult(
            @JsonProperty("status") String status,
            @JsonProperty("err-code") String errCode,
            @JsonProperty("err-msg") String errMsg,
            @JsonProperty("data") HuobiFutureAccount[] result
    ) {
        super(status,errCode, errMsg,result);
    }
}