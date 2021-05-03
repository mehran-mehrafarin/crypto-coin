package com.gamesys.crypto_coin.repository;

import com.gamesys.crypto_coin.entity.Asset;
import com.gamesys.crypto_coin.repository.impl.AssetRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Sql({"classpath:schema.sql", "classpath:test-data.sql"})
public class AssetRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private AssetRepositoryImpl repository;

    @BeforeEach
    public void before() {
        repository = new AssetRepositoryImpl(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Test
    void count_basic() {
        assertEquals(3, repository.count());
    }

    @Test
    void findAll_basic() {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void findById_basic() {
        assertEquals(1L, repository.findById(1L).get().getId());
    }

    @Test
    void findByAssetId_basic() {
        assertEquals("BTC", repository.findByAssetId("BTC").get().getAssetId());
    }

    @Test
    void save_basic() {
        assertEquals(1, repository.save(new Asset()));
    }

    @Test
    void saveAll_basic() {
        int[] result = repository.saveAll(Arrays.asList(new Asset(), new Asset()));
        assertEquals(1, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void truncate_basic() {
        repository.truncate();
        assertEquals(0, repository.count());
    }

}
