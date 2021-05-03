package com.gamesys.crypto_coin.repository;

import com.gamesys.crypto_coin.entity.Asset;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AssetRepository {

    int count();

    List<Asset> findAll();

    List<Asset> findAll(Pageable pageable);

    Optional<Asset> findById(Long id);

    Optional<Asset> findByAssetId(String assetId);

    int save(Asset entity);

    int[] saveAll(List<Asset> entities);

//    int update(Asset entity);
//
//    int[] updateAll(List<Asset> entities);
//
//    int deleteById(Long id);

    void truncate();
}
