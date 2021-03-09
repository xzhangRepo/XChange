package org.knowm.xchange.huobi.dto.marketdata.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.huobi.dto.HuobiResultV3;
import org.knowm.xchange.huobi.dto.marketdata.ContractContractInfo;

public class ContractContractInfoResult extends HuobiResultV3<ContractContractInfo[]> {


    public ContractContractInfoResult(
            @JsonProperty("status") String status,
            @JsonProperty("data") ContractContractInfo[] result,
            @JsonProperty("err_code") String errCode,
            @JsonProperty("err_msg") String errMsg) {
        super(status, errCode, errMsg, result);
    }

}
