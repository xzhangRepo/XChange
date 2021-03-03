package org.knowm.xchange.huobi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HuobiResultV3<V> {

  private final String status;
  private final String errCode;
  private final String errMsg;
  private final V result;

  @JsonCreator
  public HuobiResultV3(
          @JsonProperty("status") String status,
          @JsonProperty("err_code") String errCode,
          @JsonProperty("err_msg") String errMsg,
          @JsonProperty("data")V result) {
    this.status = status;
    this.errCode = errCode;
    this.errMsg = errMsg;
    this.result = result;
  }

  public boolean isSuccess() {
    return getStatus().equals("ok");
  }

  public String getStatus() {
    return status;
  }

  public String getError() {
    return (errMsg.length() == 0) ? errCode : errMsg;
  }

  public V getResult() {
    return result;
  }

  @Override
  public String toString() {
    return String.format(
            "HuobiResult [%s, %s]", status, isSuccess() ? getResult().toString() : getError());
  }
}
