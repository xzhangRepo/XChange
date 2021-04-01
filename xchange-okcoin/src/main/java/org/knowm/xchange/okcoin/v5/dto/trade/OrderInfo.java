package org.knowm.xchange.okcoin.v5.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderInfo {

    private String clOrdId;
    private String ordId;
    private String tag;
    private String sCode;
    private String sMsg;

    public OrderInfo(
            @JsonProperty("clOrdId")String clOrdId,
            @JsonProperty("ordId")String ordId,
            @JsonProperty("tag")String tag,
            @JsonProperty("sCode")String sCode,
            @JsonProperty("sMsg")String sMsg) {
        this.clOrdId = clOrdId;
        this.ordId = ordId;
        this.tag = tag;
        this.sCode = sCode;
        this.sMsg = sMsg;
    }
}
