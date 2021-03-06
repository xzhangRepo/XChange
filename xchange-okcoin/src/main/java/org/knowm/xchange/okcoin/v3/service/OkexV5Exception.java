package org.knowm.xchange.okcoin.v3.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import si.mazi.rescu.HttpStatusExceptionSupport;

@SuppressWarnings("serial")
@Setter
public class OkexV5Exception extends HttpStatusExceptionSupport {

  /*
  unfortunately there are different error formats provided by okex...
  {"code":30015,"message":"Invalid OK_ACCESS_PASSPHRASE"}
  {"error_message":"Contract does not exist","result":"true","error_code":"35001","order_id":"-1"}
  */

  private String code;
  private String message;

  @JsonProperty("code")
  private String errorCode;

  @JsonProperty("msg")
  private String errorMessage;

  public String getCode() {
    return code != null && !code.isEmpty() && !"0".equals(code) ? code : errorCode;
  }

  public String getErrorMessage() {
    return message != null && !message.isEmpty() ? message : errorMessage;
  }

  @Override
  public String getMessage() {
    return String.format("[%s] %s", getCode(), getErrorMessage());
  }
}
