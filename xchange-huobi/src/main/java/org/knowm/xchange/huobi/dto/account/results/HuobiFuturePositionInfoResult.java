package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.account.HuobiFuturePosition;

public class HuobiFuturePositionInfoResult  extends HuobiResultV3<HuobiFuturePosition[]> {

    public HuobiFuturePositionInfoResult(
            @JsonProperty("status") String status,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg,
            @JsonProperty("data") HuobiFuturePosition[] result
    ) {
        super(status,errCode, errMsg,result);
    }
}