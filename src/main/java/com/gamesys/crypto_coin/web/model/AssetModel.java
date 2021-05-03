package com.gamesys.crypto_coin.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AssetModel {

    private Long id;

    private String assetId;

    private String name;

    private Integer typeIsCrypto;

    private LocalDate dataStart;

    private LocalDate dataEnd;

    private LocalDateTime dataQuoteStart;

    private LocalDateTime dataQuoteEnd;

    private LocalDateTime dataOrderBookStart;

    private LocalDateTime dataOrderBookEnd;

    private LocalDateTime dataTradeStart;

    private LocalDateTime dataTradeEnd;

    private Integer dataSymbolsCount;

    private BigDecimal volumeOneHourUSD;

    private BigDecimal volumeOneDayUSD;

    private BigDecimal volumeOneMonthUSD;

    private BigDecimal priceUSD;

    private String idIcon;

    private LocalDateTime createdOn;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public LocalDate getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(LocalDate dataEnd) {
        this.dataEnd = dataEnd;
    }

    public LocalDateTime getDataQuoteStart() {
        return dataQuoteStart;
    }

    public void setDataQuoteStart(LocalDateTime dataQuoteStart) {
        this.dataQuoteStart = dataQuoteStart;
    }

    public LocalDateTime getDataQuoteEnd() {
        return dataQuoteEnd;
    }

    public void setDataQuoteEnd(LocalDateTime dataQuoteEnd) {
        this.dataQuoteEnd = dataQuoteEnd;
    }

    public LocalDateTime getDataOrderBookStart() {
        return dataOrderBookStart;
    }

    public void setDataOrderBookStart(LocalDateTime dataOrderBookStart) {
        this.dataOrderBookStart = dataOrderBookStart;
    }

    public LocalDateTime getDataOrderBookEnd() {
        return dataOrderBookEnd;
    }

    public void setDataOrderBookEnd(LocalDateTime dataOrderBookEnd) {
        this.dataOrderBookEnd = dataOrderBookEnd;
    }

    public LocalDateTime getDataTradeStart() {
        return dataTradeStart;
    }

    public void setDataTradeStart(LocalDateTime dataTradeStart) {
        this.dataTradeStart = dataTradeStart;
    }

    public LocalDateTime getDataTradeEnd() {
        return dataTradeEnd;
    }

    public void setDataTradeEnd(LocalDateTime dataTradeEnd) {
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
