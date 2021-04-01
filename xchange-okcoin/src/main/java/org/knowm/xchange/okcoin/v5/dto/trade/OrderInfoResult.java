package org.knowm.xchange.okcoin.v5.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.okcoin.v5.OkexResultV5;

import java.util.List;

public class OrderInfoResult  extends OkexResultV5<List<OrderInfo>> {

    private String code;
    private String msg;
    private List<OrderInfo> result;

    public OrderInfoResult(
            @JsonProperty("code") String code,
            @JsonProperty("msg") String msg,
            @JsonProperty("data") List<OrderInfo> result) {
        super(code, msg, result);
        this.code = code;
        this.msg = msg;
        this.result = result;
    }
}
