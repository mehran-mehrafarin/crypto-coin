DROP TABLE IF EXISTS x_asset;

CREATE TABLE x_asset
(
  id                    BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  asset_id              VARCHAR(50)        DEFAULT NULL,
  name                  VARCHAR(50)        DEFAULT NULL,
  type_is_crypto        SMALLINT UNSIGNED  DEFAULT NULL,
  data_start            DATE               DEFAULT NULL,
  data_end              DATE               DEFAULT NULL,
  data_quote_start      DATETIME           DEFAULT NULL,
  data_quote_end        DATETIME           DEFAULT NULL,
  data_order_book_start DATETIME           DEFAULT NULL,
  data_order_book_end   DATETIME           DEFAULT NULL,
  data_trade_start      DATETIME           DEFAULT NULL,
  data_trade_end        DATETIME           DEFAULT NULL,
  data_symbols_count    MEDIUMINT UNSIGNED DEFAULT NULL,
  volume_one_hour_usd   DOUBLE             DEFAULT NULL,
  volume_one_day_usd    DOUBLE             DEFAULT NULL,
  volume_one_month_usd  DOUBLE             DEFAULT NULL,
  price_usd             DOUBLE             DEFAULT NULL,
  id_icon               VARCHAR(50)        DEFAULT NULL,
  created_on            DATETIME           DEFAULT NULL,
  status                VARCHAR(50)        DEFAULT NULL
);






