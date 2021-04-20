package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class RateLimit {

    public RateLimit(
            @JsonProperty("rateLimitType") String rateLimitType,
            @JsonProperty("interval") String interval,
            @JsonProperty("intervalNum") Long intervalNum,
            @JsonProperty("limit")  Long limit) {
        this.rateLimitType = rateLimitType;
        this.interval = interval;
        this.intervalNum = intervalNum;
        this.limit = limit;
    }

    private String rateLimitType;

    private String interval;

    private Long intervalNum;

    private Long limit;

    public String getRateLimitType() {
        return rateLimitType;
    }

    public void setRateLimitType(String rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Long getIntervalNum() {
        return intervalNum;
    }

    public void setIntervalNum(Long intervalNum) {
        this.intervalNum = intervalNum;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

}
