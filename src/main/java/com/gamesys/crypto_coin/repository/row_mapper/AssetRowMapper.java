package com.gamesys.crypto_coin.repository.row_mapper;

import com.gamesys.crypto_coin.entity.Asset;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AssetRowMapper implements RowMapper<Asset> {
    @Override
    public Asset mapRow(ResultSet resultSet, int row) throws SQLException {

        Asset entity = new Asset();

        entity.setId(resultSet.getLong("id"));
        entity.setAssetId(resultSet.getString("asset_id"));
        entity.setTypeIsCrypto(resultSet.getInt("type_is_crypto"));

        if (resultSet.getTimestamp("data_start") != null)
            entity.setDataStart(resultSet.getDate("data_start").toLocalDate());

        if (resultSet.getTimestamp("data_end") != null)
            entity.setDataEnd(resultSet.getDate("data_end").toLocalDate());

        if (resultSet.getTimestamp("data_quote_start") != null)
            entity.setDataQuoteStart(resultSet.getTimestamp("data_quote_start").toLocalDateTime());

        if (resultSet.getTimestamp("data_quote_end") != null)
            entity.setDataQuoteEnd(resultSet.getTimestamp("data_quote_end").toLocalDateTime());

        if (resultSet.getTimestamp("data_order_book_start") != null)
            entity.setDataOrderBookStart(resultSet.getTimestamp("data_order_book_start").toLocalDateTime());

        if (resultSet.getTimestamp("data_order_book_end") != null)
            entity.setDataOrderBookEnd(resultSet.getTimestamp("data_order_book_end").toLocalDateTime());

        if (resultSet.getTimestamp("data_trade_start") != null)
            entity.setDataTradeStart(resultSet.getTimestamp("data_trade_start").toLocalDateTime());

        if (resultSet.getTimestamp("data_trade_end") != null)
            entity.setDataTradeEnd(resultSet.getTimestamp("data_trade_end").toLocalDateTime());

        entity.setDataSymbolsCount(resultSet.getInt("data_symbols_count"));
        entity.setVolumeOneHourUSD(resultSet.getBigDecimal("volume_one_hour_usd"));
        entity.setVolumeOneDayUSD(resultSet.getBigDecimal("volume_one_day_usd"));
        entity.setVolumeOneMonthUSD(resultSet.getBigDecimal("volume_one_month_usd"));
        entity.setPriceUSD(resultSet.getBigDecimal("price_usd"));
        entity.setIdIcon(resultSet.getString("id_icon"));

        if (resultSet.getTimestamp("created_on") != null)
            entity.setCreatedOn(resultSet.getTimestamp("created_on").toLocalDateTime());

        entity.setStatus(resultSet.getString("status"));

        return entity;
    }
}
