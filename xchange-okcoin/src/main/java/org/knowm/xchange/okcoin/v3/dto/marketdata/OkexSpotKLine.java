package org.knowm.xchange.okcoin.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.knowm.xchange.instrument.Instrument;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class OkexSpotKLine {
    @JsonIgnore
    private String instrumentId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone ="UTC")
    private Date time;//开始时间
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;

    @Override
    public String toString() {
        return "OkexSpotKLine{" +
                "time='" + time + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}
