package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiSwapAccount;
import org.knowm.xchange.huobi.dto.account.HuobiSwapPosition;

public class HuobiSwapPositionResult extends HuobiResultV3<HuobiSwapPosition[]> {

    public HuobiSwapPositionResult(
            @JsonProperty("status") String status,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg,
            @JsonProperty("data") HuobiSwapPosition[] result
    ) {
        super(status,errCode, errMsg,result);
    }
}