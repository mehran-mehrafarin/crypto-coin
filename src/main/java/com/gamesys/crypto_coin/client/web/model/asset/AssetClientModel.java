package com.gamesys.crypto_coin.client.web.model.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AssetClientModel {

    @JsonProperty("asset_id")
    private String assetId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type_is_crypto")
    private Integer typeIsCrypto;

    @JsonProperty("data_start")
    private String dataStart;

    @JsonProperty("data_end")
    private String dataEnd;

    @JsonProperty("data_quote_start")
    private String dataQuoteStart;

    @JsonProperty("data_quote_end")
    private String dataQuoteEnd;

    @JsonProperty("data_orderbook_start")
    private String dataOrderBookStart;

    @JsonProperty("data_orderbook_end")
    private String dataOrderBookEnd;

    @JsonProperty("data_trade_start")
    private String dataTradeStart;

    @JsonProperty("data_trade_end")
    private String dataTradeEnd;

    @JsonProperty("data_symbols_count")
    private Integer dataSymbolsCount;

    @JsonProperty("volume_1hrs_usd")
    private BigDecimal volumeOneHourUSD;

    @JsonProperty("volume_1day_usd")
    private BigDecimal volumeOneDayUSD;

    @JsonProperty("volume_1mth_usd")
    private BigDecimal volumeOneMonthUSD;

    @JsonProperty("price_usd")
    private BigDecimal priceUSD;

    @JsonProperty("id_icon")
    private String idIcon;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeIsCrypto() {
        return typeIsCrypto;
    }

    public void setTypeIsCrypto(Integer typeIsCrypto) {
        this.typeIsCrypto = typeIsCrypto;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public String getDataQuoteStart() {
        return dataQuoteStart;
    }

    public void setDataQuoteStart(String dataQuoteStart) {
        this.dataQuoteStart = dataQuoteStart;
    }

    public String getDataQuoteEnd() {
        return dataQuoteEnd;
    }

    public void setDataQuoteEnd(String dataQuoteEnd) {
        this.dataQuoteEnd = dataQuoteEnd;
    }

    public String getDataOrderBookStart() {
        return dataOrderBookStart;
    }

    public void setDataOrderBookStart(String dataOrderBookStart) {
        this.dataOrderBookStart = dataOrderBookStart;
    }

    public String getDataOrderBookEnd() {
        return dataOrderBookEnd;
    }

    public void setDataOrderBookEnd(String dataOrderBookEnd) {
        this.dataOrderBookEnd = dataOrderBookEnd;
    }

    public String getDataTradeStart() {
        return dataTradeStart;
    }

    public void setDataTradeStart(String dataTradeStart) {
        this.dataTradeStart = dataTradeStart;
    }

    public String getDataTradeEnd() {
        return dataTradeEnd;
    }

    public void setDataTradeEnd(String dataTradeEnd) {
        this.dataTradeEnd = dataTradeEnd;
    }

    public Integer getDataSymbolsCount() {
        return dataSymbolsCount;
    }

    public void setDataSymbolsCount(Integer dataSymbolsCount) {
        this.dataSymbolsCount = dataSymbolsCount;
    }

    public BigDecimal getVolumeOneHourUSD() {
        return volumeOneHourUSD;
    }

    public void setVolumeOneHourUSD(BigDecimal volumeOneHourUSD) {
        this.volumeOneHourUSD = volumeOneHourUSD;
    }

    public BigDecimal getVolumeOneDayUSD() {
        return volumeOneDayUSD;
    }

    public void setVolumeOneDayUSD(BigDecimal volumeOneDayUSD) {
        this.volumeOneDayUSD = volumeOneDayUSD;
    }

    public BigDecimal getVolumeOneMonthUSD() {
        return volumeOneMonthUSD;
    }

    public void setVolumeOneMonthUSD(BigDecimal volumeOneMonthUSD) {
        this.volumeOneMonthUSD = volumeOneMonthUSD;
    }

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(String idIcon) {
        this.idIcon = idIcon;
    }
}
