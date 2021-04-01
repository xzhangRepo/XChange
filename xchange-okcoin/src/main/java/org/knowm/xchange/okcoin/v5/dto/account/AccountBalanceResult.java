package org.knowm.xchange.okcoin.v5.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.okcoin.v5.OkexResultV5;

import java.util.List;

public class AccountBalanceResult  extends OkexResultV5<List<AccountBalance>> {

    public AccountBalanceResult(
            @JsonProperty("code") String code,
            @JsonProperty("msg") String msg,
            @JsonProperty("data") List<AccountBalance> result) {
        super(code, msg, result);
    }

}
