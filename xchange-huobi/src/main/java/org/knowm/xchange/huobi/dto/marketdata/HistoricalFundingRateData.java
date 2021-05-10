package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalFundingRateData {

    private int totalPage;
    private int currentPage;
    private int totalSize;
    private HistoricalFundingRate[] result;

    public HistoricalFundingRateData(
            @JsonProperty("total_page")int totalPage,
            @JsonProperty("current_page")int currentPage,
            @JsonProperty("total_size")int totalSize,
            @JsonProperty("data") HistoricalFundingRate[] result
    ) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.totalSize = totalSize;
        this.result = result;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public HistoricalFundingRate[] getResult() {
        return result;
    }

    public void setResult(HistoricalFundingRate[] result) {
        this.result = result;
    }
}
