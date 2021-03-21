package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FutureTransferRequest {

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    private String amount;
    /**
     * 从合约账户到现货账户：“futures-to-pro”，从现货账户到合约账户： “pro-to-futures”
     */
    @JsonProperty("type")
    private String type;

}
