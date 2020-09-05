package org.knowm.xchange.okcoin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.FundingRecord.Status;
import org.knowm.xchange.dto.account.FundingRecord.Type;
import org.knowm.xchange.dto.marketdata.Kline;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.StopOrder;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.instrument.Instrument;
import org.knowm.xchange.okcoin.dto.trade.OkCoinOrder;
import org.knowm.xchange.okcoin.v3.dto.account.OkexDepositRecord;
import org.knowm.xchange.okcoin.v3.dto.account.OkexFundingAccountRecord;
import org.knowm.xchange.okcoin.v3.dto.account.OkexSpotAccountRecord;
import org.knowm.xchange.okcoin.v3.dto.account.OkexWithdrawalRecord;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexOrderBook;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexOrderBookEntry;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSpotKLine;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexSpotTicker;
import org.knowm.xchange.okcoin.v3.dto.trade.FuturesAccountsResponse.FuturesAccount;
import org.knowm.xchange.okcoin.v3.dto.trade.OkexOpenOrder;
import org.knowm.xchange.okcoin.v3.dto.trade.Side;
import org.knowm.xchange.okcoin.v3.dto.trade.SwapAccountsResponse.SwapAccountInfo;

public class OkexAdaptersV3 {

  public static Balance convert(OkexFundingAccountRecord rec) {
    return new Balance.Builder()
        .currency(Currency.getInstance(rec.getCurrency()))
        .available(rec.getAvailable())
        .frozen(rec.getBalance().subtract(rec.getAvailable()))
        .total(rec.getBalance())
        .build();
  }

  public static Balance convert(OkexSpotAccountRecord rec) {
    return new Balance.Builder()
        .currency(Currency.getInstance(rec.getCurrency()))
        .available(rec.getAvailable())
        .frozen(rec.getBalance().subtract(rec.getAvailable()))
        .total(rec.getBalance())
        .build();
  }

  public static Balance convert(String currency, FuturesAccount acc) {
    return new Balance.Builder()
        .currency(Currency.getInstance(currency.toUpperCase()))
        .total(acc.getEquity())
        .build();
  }

  public static Balance convert(SwapAccountInfo rec) {
    return new Balance.Builder()
        .currency(toPair(rec.getInstrumentId()).base)
        .total(rec.getEquity())
        .build();
  }

  public static String toSpotInstrument(CurrencyPair pair) {
    return pair == null ? null : pair.base.getCurrencyCode() + "-" + pair.counter.getCurrencyCode();
  }

  /**
   * there are different types of instruments: spot (ie 'ETH-BTC'), future (ie 'BCH-USD-190927'),
   * swap (ie 'ETH-USD-SWAP')
   *
   * @param instrument
   * @return
   */
  public static CurrencyPair toPair(String instrument) {
    String[] split = instrument.split("-");
    if (split == null || split.length < 2) {
      throw new ExchangeException("Not supported instrument: " + instrument);
    }
    return new CurrencyPair(split[0], split[1]);
  }

  public static Ticker convert(OkexSpotTicker i) {
    return new Ticker.Builder()
        .currencyPair(toPair(i.getInstrumentId()))
        .last(i.getLast())
        .bid(i.getBid())
        .ask(i.getAsk())
        .volume(i.getBaseVolume24h())
        .quoteVolume(i.getQuoteVolume24h())
        .timestamp(i.getTimestamp())
        .build();
  }

  public static LimitOrder convert(OkexOpenOrder o) {
    return new LimitOrder.Builder(
            o.getSide() == Side.sell ? OrderType.ASK : OrderType.BID, toPair(o.getInstrumentId()))
        .id(o.getOrderId())
        .limitPrice(o.getPrice())
        .originalAmount(o.getSize())
        .timestamp(o.getCreatedAt())
        .build();
  }

  public static FundingRecord adaptFundingRecord(OkexWithdrawalRecord r) {
    return new FundingRecord.Builder()
        .setAddress(r.getTo())
        .setAmount(r.getAmount())
        .setCurrency(Currency.getInstance(r.getCurrency()))
        .setDate(r.getTimestamp())
        .setInternalId(r.getWithdrawalId())
        .setStatus(convertWithdrawalStatus(r.getStatus()))
        .setBlockchainTransactionHash(r.getTxid())
        .setType(Type.WITHDRAWAL)
        .build();
  }

  /**
   * -3:pending cancel; -2: cancelled; -1: failed; 0 :pending; 1 :sending; 2:sent; 3 :email
   * confirmation; 4 :manual confirmation; 5:awaiting identity confirmation
   */
  private static Status convertWithdrawalStatus(String status) {
    switch (status) {
      case "-3":
      case "-2":
        return Status.CANCELLED;
      case "-1":
        return Status.FAILED;
      case "0":
      case "1":
      case "3":
      case "4":
      case "5":
        return Status.PROCESSING;
      case "2":
        return Status.COMPLETE;
      default:
        throw new ExchangeException("Unknown withdrawal status: " + status);
    }
  }

  public static FundingRecord adaptFundingRecord(OkexDepositRecord r) {
    return new FundingRecord.Builder()
        .setAddress(r.getTo())
        .setAmount(r.getAmount())
        .setCurrency(Currency.getInstance(r.getCurrency()))
        .setDate(r.getTimestamp())
        .setStatus(convertDepositStatus(r.getStatus()))
        .setBlockchainTransactionHash(r.getTxid())
        .setType(Type.DEPOSIT)
        .build();
  }
  /**
   * The status of deposits (0: waiting for confirmation; 1: confirmation account; 2: recharge
   * success);
   */
  private static Status convertDepositStatus(String status) {
    switch (status) {
      case "0":
      case "1":
      case "6":
        return Status.PROCESSING;
      case "2":
        return Status.COMPLETE;
      default:
        throw new ExchangeException("Unknown deposit status: " + status);
    }
  }

  public static OrderBook convertOrderBook(OkexOrderBook book, CurrencyPair currencyPair) {

    List<LimitOrder> asks = toLimitOrderList(book.getAsks(), OrderType.ASK, currencyPair);
    List<LimitOrder> bids = toLimitOrderList(book.getBids(), OrderType.BID, currencyPair);

    return new OrderBook(null, asks, bids);
  }

  private static List<LimitOrder> toLimitOrderList(
      OkexOrderBookEntry[] levels, OrderType orderType, CurrencyPair currencyPair) {

    List<LimitOrder> allLevels = new ArrayList<>();

    if (levels != null) {
      for (int i = 0; i < levels.length; i++) {
        OkexOrderBookEntry ask = levels[i];

        allLevels.add(
            new LimitOrder(orderType, ask.getVolume(), currencyPair, "0", null, ask.getPrice()));
      }
    }

    return allLevels;
  }

  private static Kline adaptKline(OkexSpotKLine okexKline) {
    return new Kline.Builder()
            .currencyPair(toPair(okexKline.getInstrumentId()))
            .openTime(okexKline.getTime().getTime())
            .high(okexKline.getHigh())
            .open(okexKline.getOpen())
            .close(okexKline.getClose())
            .low(okexKline.getLow())
            .volume(okexKline.getVolume())
            .closeTime(okexKline.getTime().getTime())
            .build();
  }

  public static List<Kline> adaptKline(List<OkexSpotKLine> binanceKlines) {
    return binanceKlines.stream()
            .map(OkexAdaptersV3::adaptKline)
            .collect(Collectors.toList());
  }

  public static Order.OrderStatus adaptOrderStatus(String orderStatus) {
//    "-2":Failed,"-1":Cancelled,"0":Open ,"1":Partially Filled, "2":Fully
//            * Filled,"3":Submitting,"4":Cancelling
    switch (orderStatus) {
      case "-2":
        return Order.OrderStatus.STOPPED;
      case "-1":
        return Order.OrderStatus.CANCELED;
      case "0":
        return Order.OrderStatus.NEW;
      case "1":
        return Order.OrderStatus.PARTIALLY_FILLED;
      case "2":
        return Order.OrderStatus.FILLED;
      case "3":
        return Order.OrderStatus.PENDING_NEW;
      case "4":
        return Order.OrderStatus.PENDING_CANCEL;
      default:
        return Order.OrderStatus.UNKNOWN;
    }
  }

  public static Order adaptOkCoinOrder(OkexOpenOrder order){
    OrderType type = order.getSide() == Side.sell ? OrderType.ASK : OrderType.BID;
    CurrencyPair currencyPair = toPair(order.getInstrumentId());
    Order.Builder builder = new LimitOrder.Builder(type, currencyPair).limitPrice(order.getPrice());
    builder
            .orderStatus(adaptOrderStatus(order.getState()))
            .originalAmount(order.getPrice())
            .id(order.getOrderId())
            .timestamp(order.getTimestamp())
            .cumulativeAmount(order.getFilledSize());
    return builder.build();
  }
}
