package org.knowm.xchange.okcoin.v5.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.okcoin.v5.OkexResultV5;

import java.math.BigDecimal;
import java.util.List;

public class AccountPositionResult extends OkexResultV5<List<AccountPosition>> {

    public AccountPositionResult(
            @JsonProperty("code") String code,
            @JsonProperty("msg") String msg,
            @JsonProperty("data") List<AccountPosition> result) {
        super(code, msg, result);
    }

}
