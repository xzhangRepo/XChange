package org.knowm.xchange.huobi.dto.account.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV2;

public class HuobiSwapTransferResult  extends HuobiResultV2<String> {

    public HuobiSwapTransferResult(
            @JsonProperty("code") String code,
            @JsonProperty("message") String message,
            @JsonProperty("data") String result
    ) {
        super(code, message,result);
    }
}