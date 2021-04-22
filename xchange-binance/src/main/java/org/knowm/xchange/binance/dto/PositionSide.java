package org.knowm.xchange.binance.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.knowm.xchange.binance.dto.trade.OrderSide;

public enum PositionSide {

    BOTH,
    LONG,
    SHORT;

    @JsonCreator
    public static OrderSide getOrderSide(String s) {
        try {
            return OrderSide.valueOf(s);
        } catch (Exception e) {
            throw new RuntimeException("Unknown order side " + s + ".");
        }
    }
}
