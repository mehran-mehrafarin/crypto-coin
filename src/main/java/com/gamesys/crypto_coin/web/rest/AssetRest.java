package com.gamesys.crypto_coin.web.rest;

import com.gamesys.crypto_coin.client.service.AssetClientService;
import com.gamesys.crypto_coin.service.AssetService;
import com.gamesys.crypto_coin.web.model.request.TemplateRequestModel;
import com.gamesys.crypto_coin.web.model.response.ResponseModel;
import com.gamesys.crypto_coin.web.model.response.TemplateResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/api/v1/assets")
public class AssetRest {

    private AssetService service;

    private AssetClientService clientService;

    private Environment environment;

    @Autowired
    public AssetRest(AssetService service, AssetClientService clientService, Environment environment) {
        this.service = service;
        this.clientService = clientService;
        this.environment = environment;
    }


    @GetMapping
    public ResponseEntity get() {
        TemplateResponseModel response = service.get();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/pagination")
    public ResponseEntity getPaginated(TemplateRequestModel request) {
        if (request.getPage() == null || request.getSize() == null || request.getPage() < 0 || request.getSize() < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TemplateResponseModel(environment.getProperty("message.title.error"), environment.getProperty("message.body.error.get.asset.bad.request")));
        TemplateResponseModel response = service.getPaginated(request);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/{assetId}")
    public ResponseEntity getPaginated(@PathVariable("assetId") @NotBlank String assetId) {
        TemplateResponseModel response = service.getByAssetId(assetId);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/update")
    public ResponseEntity update() {
        ResponseModel response = clientService.update();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }
}
