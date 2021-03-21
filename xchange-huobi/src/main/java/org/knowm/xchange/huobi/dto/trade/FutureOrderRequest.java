package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FutureOrderRequest {

    private String symbol;
    @JsonProperty("contract_type")
    private String contractType;
    @JsonProperty("contract_code")
    private String contractCode;
//    @JsonProperty("client_order_id")
//    private long clientOrderId;
    private BigDecimal price;
    private BigDecimal volume;
    private String direction;
    private String offset;
    @JsonProperty("lever_rate")
    private BigDecimal leverRate;
    @JsonProperty("order_price_type")
    private String orderPriceType;


}
