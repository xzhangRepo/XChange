package org.knowm.xchange.okcoin.v5.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest {

    //产品ID，如 BTC-USD-190927-5000-C
    private String instId;
    /**
     * 交易模式
     * 保证金模式：isolated：逐仓 ；cross：全仓
     * 非保证金模式：cash：非保证金
     */
    private String tdMode;
    /**
     * 保证金币种，仅适用于单币种保证金模式下的全仓杠杆订单
     */
    private String ccy;
    /**
     * 客户自定义订单ID
     * 字母（区分大小写）与数字的组合，必须以字母开头，可以是纯字母，且长度要在1-32位之间。
     */
    private String clOrdId;
    /**
     * 订单标签
     * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字，且长度在1-8位之间。
     */
    private String tag;
    /**
     * 订单方向 buy：买 sell：卖
     */
    private String side;
    /**
     *持仓方向 在双向持仓模式下必填，且仅可选择 long 或 short
     */
    private String posSide;
    /**
     *订单类型
     * market：市价单
     * limit：限价单
     * post_only：只做maker单
     * fok：全部成交或立即取消
     * ioc：立即成交并取消剩余
     */
    private String ordType;
    /**
     * 委托数量
     */
    private BigDecimal sz;
    /**
     * 委托价格，仅适用于限价单
     */
    private BigDecimal px;
    /**
     * 是否只减仓，true 或 false，默认false
     * 仅适用于币币杠杆订单
     */
    private boolean reduceOnly;

}
