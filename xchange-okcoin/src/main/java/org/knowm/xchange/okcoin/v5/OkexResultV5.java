package org.knowm.xchange.okcoin.v5;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OkexResultV5<V>{

    private final String code;
    private final String msg;
    private final V result;

    @JsonCreator
    public OkexResultV5(
            @JsonProperty("code") String code,
            @JsonProperty("msg") String msg,
            @JsonProperty("data")V result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public boolean isSuccess() {
        return getCode().equals("0");
    }

    public String getCode() {
        return code;
    }

    public String getError() {
        return msg;
    }

    public V getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "OkexResultV5{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
