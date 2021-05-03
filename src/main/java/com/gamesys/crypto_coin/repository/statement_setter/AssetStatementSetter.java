package com.gamesys.crypto_coin.repository.statement_setter;

import com.gamesys.crypto_coin.entity.Asset;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AssetStatementSetter implements PreparedStatementSetter {

    private Asset entity;

    public AssetStatementSetter(Asset entity) {
        this.entity = entity;
    }

    @Override
    public void setValues(PreparedStatement ps) throws SQLException {

        String id = null;
        String typeIsCrypto = null;
        Date dataStart = null;
        Date dataEnd = null;
        Timestamp dataQuoteStart = null;
        Timestamp dataQuoteEnd = null;
        Timestamp dataOrderBookStart = null;
        Timestamp dataOrderBookEnd = null;
        Timestamp dataTradeStart = null;
        Timestamp dataTradeEnd = null;
        String dataSymbolsCount = null;
        Timestamp createdOn = null;

        if (entity.getId() != null)
            id = String.valueOf(entity.getId());

        if (entity.getTypeIsCrypto() != null)
            typeIsCrypto = String.valueOf(entity.getTypeIsCrypto());

        if (entity.getDataStart() != null)
            dataStart = Date.valueOf(entity.getDataStart());

        if (entity.getDataEnd() != null)
            dataEnd = Date.valueOf(entity.getDataEnd());

        if (entity.getDataQuoteStart() != null)
            dataQuoteStart = Timestamp.valueOf(entity.getDataQuoteStart());

        if (entity.getDataQuoteEnd() != null)
            dataQuoteEnd = Timestamp.valueOf(entity.getDataQuoteEnd());

        if (entity.getDataOrderBookStart() != null)
            dataOrderBookStart = Timestamp.valueOf(entity.getDataOrderBookStart());

        if (entity.getDataOrderBookEnd() != null)
            dataOrderBookEnd = Timestamp.valueOf(entity.getDataOrderBookEnd());

        if (entity.getDataTradeStart() != null)
            dataTradeStart = Timestamp.valueOf(entity.getDataTradeStart());

        if (entity.getDataTradeEnd() != null)
            dataTradeEnd = Timestamp.valueOf(entity.getDataTradeEnd());

        if (entity.getDataSymbolsCount() != null)
            dataSymbolsCount = String.valueOf(entity.getDataSymbolsCount());

        if (entity.getCreatedOn() != null)
            createdOn = Timestamp.valueOf(entity.getCreatedOn());

        ps.setString(1, id);
        ps.setString(2, entity.getAssetId());
        ps.setString(3, entity.getName());
        ps.setString(4, typeIsCrypto);
        ps.setDate(5, dataStart);
        ps.setDate(6, dataEnd);
        ps.setTimestamp(7, dataQuoteStart);
        ps.setTimestamp(8, dataQuoteEnd);
        ps.setTimestamp(9, dataOrderBookStart);
        ps.setTimestamp(10, dataOrderBookEnd);
        ps.setTimestamp(11, dataTradeStart);
        ps.setTimestamp(12, dataTradeEnd);
        ps.setString(13, dataSymbolsCount);
        ps.setBigDecimal(14, entity.getVolumeOneHourUSD());
        ps.setBigDecimal(15, entity.getVolumeOneDayUSD());
        ps.setBigDecimal(16, entity.getVolumeOneMonthUSD());
        ps.setBigDecimal(17, entity.getPriceUSD());
        ps.setString(18, entity.getIdIcon());
        ps.setTimestamp(19, createdOn);
        ps.setString(20, entity.getStatus());

    }
}
