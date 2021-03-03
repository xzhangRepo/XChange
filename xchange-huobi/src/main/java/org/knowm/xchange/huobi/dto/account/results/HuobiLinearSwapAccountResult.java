package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiLinearSwapAccount;
import org.knowm.xchange.huobi.dto.account.HuobiSwapAccount;

public class HuobiLinearSwapAccountResult extends HuobiResultV3<HuobiLinearSwapAccount[]> {

    public HuobiLinearSwapAccountResult(
            @JsonProperty("status") String status,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg,
            @JsonProperty("data") HuobiLinearSwapAccount[] result
    ) {
        super(status,errCode, errMsg,result);
    }
}