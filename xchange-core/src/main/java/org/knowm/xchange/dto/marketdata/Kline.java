package org.knowm.xchange.dto.marketdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.instrument.Instrument;
import org.knowm.xchange.utils.Assert;

@JsonDeserialize(builder = Kline.Builder.class)
public class Kline implements Serializable {
  private final Instrument instrument;
  private final long openTime;
  private final BigDecimal open;
  private final BigDecimal high;
  private final BigDecimal low;
  private final BigDecimal close;
  private final BigDecimal volume;
  private final long closeTime;
  private final BigDecimal quoteAssetVolume;
  private final long numberOfTrades;
  private final BigDecimal takerBuyBaseAssetVolume;
  private final BigDecimal takerBuyQuoteAssetVolume;

  private Kline(
      Instrument instrument,
      long openTime,
      BigDecimal open,
      BigDecimal high,
      BigDecimal low,
      BigDecimal close,
      BigDecimal volume,
      long closeTime,
      BigDecimal quoteAssetVolume,
      long numberOfTrades,
      BigDecimal takerBuyBaseAssetVolume,
      BigDecimal takerBuyQuoteAssetVolume) {
    this.instrument = instrument;
    this.openTime = openTime;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
    this.closeTime = closeTime;
    this.quoteAssetVolume = quoteAssetVolume;
    this.numberOfTrades = numberOfTrades;
    this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
  }

  public Instrument getInstrument() {
    return instrument;
  }

  /**
   * @deprecated CurrencyPair is a subtype of Instrument - this method will throw an exception if
   *     the order was for a derivative
   *     <p>use {@link #getInstrument()} instead
   */
  @Deprecated
  public CurrencyPair getCurrencyPair() {
    if (!(instrument instanceof CurrencyPair)) {
      throw new IllegalStateException(
          "The instrument of this order is not a currency pair: " + instrument);
    }
    return (CurrencyPair) instrument;
  }

  public long getOpenTime() {
    return openTime;
  }

  public BigDecimal getOpenPrice() {
    return open;
  }

  public BigDecimal getHighPrice() {
    return high;
  }

  public BigDecimal getLowPrice() {
    return low;
  }

  public BigDecimal getAveragePrice() {
    return low.add(high).divide(new BigDecimal("2"));
  }

  public BigDecimal getClosePrice() {
    return close;
  }

  public BigDecimal getVolume() {
    return volume;
  }

  public long getCloseTime() {
    return closeTime;
  }

  public BigDecimal getQuoteAssetVolume() {
    return quoteAssetVolume;
  }

  public long getNumberOfTrades() {
    return numberOfTrades;
  }

  public BigDecimal getTakerBuyBaseAssetVolume() {
    return takerBuyBaseAssetVolume;
  }

  public BigDecimal getTakerBuyQuoteAssetVolume() {
    return takerBuyQuoteAssetVolume;
  }

  @Override
  public String toString() {
    return "Kline{"
        + "instrument="
        + instrument
        + ", openTime="
        + openTime
        + ", open="
        + open
        + ", high="
        + high
        + ", low="
        + low
        + ", close="
        + close
        + ", volume="
        + volume
        + ", closeTime="
        + closeTime
        + ", quoteAssetVolume="
        + quoteAssetVolume
        + ", numberOfTrades="
        + numberOfTrades
        + ", takerBuyBaseAssetVolume="
        + takerBuyBaseAssetVolume
        + ", takerBuyQuoteAssetVolume="
        + takerBuyQuoteAssetVolume
        + '}';
  }

  @JsonPOJOBuilder(withPrefix = "")
  public static class Builder {

    private Instrument instrument;
    private long openTime;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private long closeTime;
    private BigDecimal quoteAssetVolume;
    private long numberOfTrades;
    private BigDecimal takerBuyBaseAssetVolume;
    private BigDecimal takerBuyQuoteAssetVolume;

    // Prevent repeat builds
    private boolean isBuilt = false;

    public Kline build() {

      validateState();

      Kline kline =
          new Kline(
              instrument,
              openTime,
              open,
              high,
              low,
              close,
              volume,
              closeTime,
              quoteAssetVolume,
              numberOfTrades,
              takerBuyBaseAssetVolume,
              takerBuyQuoteAssetVolume);

      isBuilt = true;

      return kline;
    }

    private void validateState() {

      if (isBuilt) {
        throw new IllegalStateException("The entity has been built");
      }
    }

    public Builder instrument(Instrument instrument) {
      Assert.notNull(instrument, "Null instrument");
      this.instrument = instrument;
      return this;
    }

    /** @deprecated Use {@link #instrument(Instrument)} */
    @Deprecated
    public Builder currencyPair(CurrencyPair currencyPair) {
      return instrument(currencyPair);
    }

    public Builder openTime(Long openTime) {
      this.openTime = openTime;
      return this;
    }

    public Builder open(BigDecimal open) {
      this.open = open;
      return this;
    }

    public Builder high(BigDecimal high) {
      this.high = high;
      return this;
    }

    public Builder low(BigDecimal low) {

      this.low = low;
      return this;
    }

    public Builder close(BigDecimal close) {

      this.close = close;
      return this;
    }

    public Builder volume(BigDecimal volume) {

      this.volume = volume;
      return this;
    }

    public Builder closeTime(Long closeTime) {

      this.closeTime = closeTime;
      return this;
    }

    public Builder quoteAssetVolume(BigDecimal quoteAssetVolume) {

      this.quoteAssetVolume = quoteAssetVolume;
      return this;
    }

    public Builder numberOfTrades(Long numberOfTrades) {

      this.numberOfTrades = numberOfTrades;
      return this;
    }

    public Builder takerBuyBaseAssetVolume(BigDecimal takerBuyBaseAssetVolume) {

      this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
      return this;
    }

    public Builder takerBuyQuoteAssetVolume(BigDecimal takerBuyQuoteAssetVolume) {

      this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
      return this;
    }
  }
}
