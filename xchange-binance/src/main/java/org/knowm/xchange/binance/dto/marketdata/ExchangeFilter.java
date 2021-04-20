package org.knowm.xchange.binance.dto.marketdata;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class ExchangeFilter {
    public ExchangeFilter() {
    }

    //    private String filterType;
//
//    private Long maxNumOrders;
//
//    private Long maxNumAlgoOrders;
//
//    public String getFilterType() {
//        return filterType;
//    }
//
//    public void setFilterType(String filterType) {
//        this.filterType = filterType;
//    }
//
//    public Long getMaxNumOrders() {
//        return maxNumOrders;
//    }
//
//    public void setMaxNumOrders(Long maxNumOrders) {
//        this.maxNumOrders = maxNumOrders;
//    }
//
//    public Long getMaxNumAlgoOrders() {
//        return maxNumAlgoOrders;
//    }
//
//    public void setMaxNumAlgoOrders(Long maxNumAlgoOrders) {
//        this.maxNumAlgoOrders = maxNumAlgoOrders;
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("filterType", filterType)
//                .append("maxNumOrders", maxNumOrders).append("maxNumAlgoOrders", maxNumAlgoOrders).toString();
//    }
}
