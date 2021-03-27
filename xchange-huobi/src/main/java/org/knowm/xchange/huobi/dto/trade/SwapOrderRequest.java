package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwapOrderRequest {

    private String contractCode;
    private BigDecimal price;
    private BigDecimal volume;
    private String direction;
    private String offset;
    private int leverRate;
    private String orderPriceType;
}
