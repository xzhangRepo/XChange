package org.knowm.xchange.okcoin.v5.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.okcoin.v5.OkexResultV5;

import java.util.List;

public class OkexFundRateResult extends OkexResultV5<List<OkexFundRate>> {

    public OkexFundRateResult(
            @JsonProperty("code") String code,
            @JsonProperty("msg") String msg,
            @JsonProperty("data") List<OkexFundRate> result) {
        super(code, msg, result);
    }
}
