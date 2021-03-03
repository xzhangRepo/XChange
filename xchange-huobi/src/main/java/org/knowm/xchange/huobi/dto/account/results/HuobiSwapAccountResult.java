package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiFutureAccount;
import org.knowm.xchange.huobi.dto.account.HuobiSwapAccount;

public class HuobiSwapAccountResult extends HuobiResultV3<HuobiSwapAccount[]> {

    public HuobiSwapAccountResult(
            @JsonProperty("status") String status,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg,
            @JsonProperty("data") HuobiSwapAccount[] result
    ) {
        super(status,errCode, errMsg,result);
    }
}