package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiLinearSwapAccount;
import org.knowm.xchange.huobi.dto.account.HuobiLinearSwapCrossAccount;

public class HuobiLinearSwapCrossAccountResult extends HuobiResultV3<HuobiLinearSwapCrossAccount[]> {

    public HuobiLinearSwapCrossAccountResult(
            @JsonProperty("status") String status,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg,
            @JsonProperty("data") HuobiLinearSwapCrossAccount[] result
    ) {
        super(status,errCode, errMsg,result);
    }
}