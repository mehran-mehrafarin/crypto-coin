package com.gamesys.crypto_coin.client.service.impl;

import com.gamesys.crypto_coin.client.service.AssetClientService;
import com.gamesys.crypto_coin.client.web.model.asset.AssetClientModel;
import com.gamesys.crypto_coin.client.web.rest.AssetClientRest;
import com.gamesys.crypto_coin.entity.Asset;
import com.gamesys.crypto_coin.repository.AssetRepository;
import com.gamesys.crypto_coin.web.model.response.ResponseModel;
import com.gamesys.crypto_coin.web.model.response.TemplateResponseModel;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetClientServiceImpl implements AssetClientService {


    private AssetClientRest rest;

    private AssetRepository repository;

    private Environment environment;

    private final Logger log = LoggerFactory.getLogger(AssetClientServiceImpl.class);

    @Autowired
    public AssetClientServiceImpl(AssetClientRest rest, AssetRepository repository, Environment environment) {
        this.rest = rest;
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    @Transactional
    public ResponseModel update() {

        String apiKey = environment.getProperty("coin.api.api.key");

        try {

            List<AssetClientModel> models = rest.getAll(apiKey);

            if (models == null)
                return new TemplateResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("message.title.internal.server.error"), environment.getProperty("message.body.error.get.asset"));

            List<Asset> entities = modelsToEntities(models);
            repository.truncate();
            repository.saveAll(entities);
        } catch (FeignException ex) {
            String logMessage = "status code: %s - message: %s - response body: %s";
            log.debug(String.format(logMessage, ex.status(), ex.getMessage(), ex.responseBody()));
            return new TemplateResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("message.title.internal.server.error"), environment.getProperty("message.body.error.get.asset"));
        }

        return new TemplateResponseModel(HttpStatus.OK, environment.getProperty("message.title.success"), environment.getProperty("message.body.success.get.asset"));
    }

    private List<Asset> modelsToEntities(List<AssetClientModel> models) {
        List<Asset> entities = new ArrayList<>();
        LocalDateTime createdOn = LocalDateTime.now();

        models.forEach(e -> {
                    Asset entity = modelToEntity(e);
                    entity.setCreatedOn(createdOn);
                    entity.setStatus("active");
                    entities.add(entity);
                }
        );

        return entities;
    }

    private Asset modelToEntity(AssetClientModel model) {

        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");

        Asset entity = new Asset();
        entity.setAssetId(model.getAssetId());
        entity.setName(model.getName());
        entity.setTypeIsCrypto(model.getTypeIsCrypto());
        entity.setDataSymbolsCount(model.getDataSymbolsCount());

        if (model.getDataStart() != null)
            entity.setDataStart(LocalDate.parse(model.getDataStart(), datePattern));

        if (model.getDataEnd() != null)
            entity.setDataEnd(LocalDate.parse(model.getDataEnd(), datePattern));

        if (model.getDataQuoteStart() != null)
            entity.setDataQuoteStart(LocalDateTime.parse(model.getDataQuoteStart(), dateTimePattern));

        if (model.getDataQuoteEnd() != null)
            entity.setDataQuoteEnd(LocalDateTime.parse(model.getDataQuoteEnd(), dateTimePattern));

        if (model.getDataOrderBookStart() != null)
            entity.setDataOrderBookStart(LocalDateTime.parse(model.getDataOrderBookStart(), dateTimePattern));

        if (model.getDataOrderBookEnd() != null)
            entity.setDataOrderBookEnd(LocalDateTime.parse(model.getDataOrderBookEnd(), dateTimePattern));

        if (model.getDataTradeStart() != null)
            entity.setDataTradeStart(LocalDateTime.parse(model.getDataTradeStart(), dateTimePattern));

        if (model.getDataTradeEnd() != null)
            entity.setDataTradeEnd(LocalDateTime.parse(model.getDataTradeEnd(), dateTimePattern));

        entity.setVolumeOneHourUSD(model.getVolumeOneHourUSD());
        entity.setVolumeOneDayUSD(model.getVolumeOneDayUSD());
        entity.setVolumeOneMonthUSD(model.getVolumeOneMonthUSD());
        entity.setPriceUSD(model.getPriceUSD());
        entity.setIdIcon(model.getIdIcon());

        return entity;

    }
}
