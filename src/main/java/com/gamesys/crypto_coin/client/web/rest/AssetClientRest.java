package com.gamesys.crypto_coin.client.web.rest;

import com.gamesys.crypto_coin.client.web.model.asset.AssetClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "asset", url = "${coin.api.endpoint.url}")
public interface AssetClientRest {

    @RequestMapping(method = RequestMethod.GET, value = "${coin.api.path.asset}", consumes = "application/json")
    List<AssetClientModel> getAll(@RequestHeader("X-CoinAPI-Key") String apiKey
    );

    @RequestMapping(method = RequestMethod.GET, value = "${coin.api.path.asset}", consumes = "application/json")
    List<AssetClientModel> getAllByAssetId(@RequestHeader("X-CoinAPI-Key") String apiKey,
                               @RequestParam(name = "filter_asset_id") String filterAssetId
    );
}
