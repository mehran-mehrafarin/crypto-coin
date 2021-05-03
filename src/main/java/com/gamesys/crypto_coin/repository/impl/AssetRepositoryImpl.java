package com.gamesys.crypto_coin.repository.impl;

import com.gamesys.crypto_coin.entity.Asset;
import com.gamesys.crypto_coin.repository.AssetRepository;
import com.gamesys.crypto_coin.repository.row_mapper.AssetRowMapper;
import com.gamesys.crypto_coin.repository.statement_setter.AssetBatchStatementSetter;
import com.gamesys.crypto_coin.repository.statement_setter.AssetStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AssetRepositoryImpl implements AssetRepository {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AssetRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM x_asset", Integer.class);
    }

    @Override
    public List<Asset> findAll() {
        return jdbcTemplate.query("SELECT * FROM x_asset", new AssetRowMapper());
    }

    @Override
    public List<Asset> findAll(Pageable pageable) {

        return jdbcTemplate.query(String.format("SELECT * FROM x_asset LIMIT %s OFFSET %s", pageable.getPageSize(), pageable.getOffset()), new AssetRowMapper());

    }

    @Override
    public Optional<Asset> findById(Long id) {

        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM x_asset WHERE id = ?", new Object[]{id}, Integer.class);
        if (count == null || count == 0)
            return Optional.empty();

        return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM x_asset WHERE id = ?", new Object[]{id}, new AssetRowMapper()));

    }

    @Override
    public Optional<Asset> findByAssetId(String assetId) {

        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM x_asset WHERE asset_id = ?", new Object[]{assetId}, Integer.class);
        if (count == null || count == 0)
            return Optional.empty();

        return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM x_asset WHERE asset_id = ?", new Object[]{assetId}, new AssetRowMapper()));
    }

    @Override
    public int save(Asset entity) {
        return jdbcTemplate.update(
                "INSERT INTO x_asset( id,  asset_id, name,  type_is_crypto, data_start, data_end, data_quote_start, data_quote_end, data_order_book_start, data_order_book_end, data_trade_start, data_trade_end, data_symbols_count, volume_one_hour_usd, volume_one_day_usd, volume_one_month_usd, price_usd, id_icon, created_on, status)" +
                        "         VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new AssetStatementSetter(entity));
    }

//    @Override
//    public int save(Asset entity) {
//        return namedParameterJdbcTemplate.update(
//                "INSERT INTO x_asset( id,  asset_id, name,  type_is_crypto, data_start, data_end, data_quote_start, data_quote_end, data_order_book_start, data_order_book_end, data_trade_start, data_trade_end, data_symbols_count, volume_one_hour_usd, volume_one_day_usd, volume_one_month_usd, price_usd, id_icon, created_on, status)" +
//                        "        VALUES(:id, :assetId, :name, :typeIsCrypto,  :dataStart, :dataEnd, :dataQuoteStart,  :dataQuoteEnd,  :dataOrderBookStart,   :dataOrderBookEnd,   :dataTradeStart,  :dataTradeEnd,  :dataSymbolsCount,   :volumeOneHourUSD,   :volumeOneDayUSD,   :volumeOneMonthUSD,   :priceUSD, :idIcon, :createdOn, :status)",
//                new BeanPropertySqlParameterSource(entity));
//    }

    @Override
    public int[] saveAll(List<Asset> entities) {
        return this.jdbcTemplate.batchUpdate(
                "INSERT INTO x_asset (id,  asset_id, name,  type_is_crypto, data_start, data_end, data_quote_start, data_quote_end, data_order_book_start, data_order_book_end, data_trade_start, data_trade_end, data_symbols_count, volume_one_hour_usd, volume_one_day_usd, volume_one_month_usd, price_usd, id_icon, created_on, status) " +
                        "          VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new AssetBatchStatementSetter(entities));
    }

//    @Override
//    public int update(Asset entity) {
//        return jdbcTemplate.update(
//                "UPDATE x_asset SET price = ? WHERE id = ?",
//                entity.getAssetId(), entity.getId());
//    }
//
//
//    @Override
//    public int[] updateAll(List<Asset> entities) {
//        return this.jdbcTemplate.batchUpdate(
//                "INSERT INTO x_asset (id,  asset_id, name,  type_is_crypto, data_start, data_end, data_quote_start, data_quote_end, data_order_book_start, data_order_book_end, data_trade_start, data_trade_end, data_symbols_count, volume_one_hour_usd, volume_one_day_usd, volume_one_month_usd, price_usd, id_icon, created_on, status) " +
//                        "          VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" +
//                        "          ON DUPLICATE KEY UPDATE asset_id=VALUES(asset_id), name=VALUES(name), type_is_crypto=VALUES(type_is_crypto), data_start=VALUES(data_start), data_end=VALUES(data_end), data_quote_start=VALUES(data_quote_start), data_quote_end=VALUES(data_quote_end), data_order_book_start=VALUES(data_order_book_start), data_order_book_end=VALUES(data_order_book_end), data_trade_start=VALUES(data_trade_start), data_trade_end=VALUES(data_trade_end), data_symbols_count=VALUES(data_symbols_count), volume_one_hour_usd=VALUES(volume_one_hour_usd), volume_one_day_usd=VALUES(volume_one_day_usd), volume_one_month_usd=VALUES(volume_one_month_usd), price_usd=VALUES(price_usd), id_icon=VALUES(id_icon), created_on=VALUES(created_on), status=VALUES(status);",
//                new AssetBatchStatementSetter(entities));
//    }
//
//    @Override
//    public int deleteById(Long id) {
//        return jdbcTemplate.update("DELETE FROM x_asset WHERE id = ?", id);
//    }

    @Override
    public void truncate() {
        jdbcTemplate.execute("TRUNCATE TABLE x_asset");
    }

}
