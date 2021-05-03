package com.gamesys.crypto_coin.task;

import com.gamesys.crypto_coin.client.service.AssetClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class AssetUpdateTask {

    private AssetClientService service;

    private final Logger log = LoggerFactory.getLogger(AssetUpdateTask.class);

    @Autowired
    public AssetUpdateTask(AssetClientService service) {
        this.service = service;
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void update() {
        log.info("Fetching data is started");
        service.update();
        log.info("Fetching data is finished");
    }


}
