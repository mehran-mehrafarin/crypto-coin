package com.gamesys.crypto_coin;

import com.gamesys.crypto_coin.client.service.AssetClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CryptoCoinApplication implements ApplicationRunner {

    private AssetClientService service;

    private final Logger log = LoggerFactory.getLogger(CryptoCoinApplication.class);

    @Autowired
    public CryptoCoinApplication(AssetClientService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(CryptoCoinApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Fetching data is started");
        service.update();
        log.info("Fetching data is finished");
    }
}
