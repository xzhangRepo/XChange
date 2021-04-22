package org.knowm.xchange.binance.dto.trade;

import lombok.Data;

@Data
public class BinanceFutureOrder {
        private String clientOrderId;
        private String cumQty;
        private String cumBase;
        private String executedQty;
        private long orderId;
        private String avgPrice;
        private String origQty;
        private String price;
        private boolean reduceOnly;
        private boolean closePosition;
        private String side;
        private String positionSide;
        private String status;
        private String stopPrice;
        private String symbol;
        private String pair;
        private String timeInForce;
        private String type;
        private String origType;
        private String activatePrice;
        private String priceRate;
        private long updateTime;
        private String workingType;
        private boolean priceProtect;
}
