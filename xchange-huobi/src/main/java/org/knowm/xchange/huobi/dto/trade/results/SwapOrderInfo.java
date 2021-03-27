package org.knowm.xchange.huobi.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SwapOrderInfo {

    private long orderId;

    private String orderIdStr;

    public SwapOrderInfo(
            @JsonProperty("order_id") long orderId,
            @JsonProperty("order_id_str") String orderIdStr) {
        this.orderId = orderId;
        this.orderIdStr = orderIdStr;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderIdStr() {
        return orderIdStr;
    }

    public void setOrderIdStr(String orderIdStr) {
        this.orderIdStr = orderIdStr;
    }

    @Override
    public String toString() {
        return "FutureOrderInfo{" +
                "orderId=" + orderId +
                ", orderIdStr='" + orderIdStr + '\'' +
                '}';
    }
}
