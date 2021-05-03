package com.gamesys.crypto_coin.web.rest;

import com.gamesys.crypto_coin.client.service.AssetClientService;
import com.gamesys.crypto_coin.web.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/assets")
public class AssetRest {

    private AssetClientService service;

    @Autowired
    public AssetRest(AssetClientService service) {
        this.service = service;
    }

    @GetMapping("/update")
    public ResponseEntity update() {
        ResponseModel response = service.update();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }
}
