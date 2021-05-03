package com.gamesys.crypto_coin.client.service.impl;

import com.gamesys.crypto_coin.client.web.model.asset.AssetClientModel;
import com.gamesys.crypto_coin.client.web.rest.AssetClientRest;
import com.gamesys.crypto_coin.repository.AssetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssetClientServiceImplTest {

    @InjectMocks
    private AssetClientServiceImpl service;

    @Mock
    private AssetClientRest rest;

    @Mock
    private AssetRepository repository;

    @Mock
    private Environment environment;

    @Test
    public void update_basic() {
        when(environment.getProperty("coin.api.api.key")).thenReturn("test");
        when(rest.getAll("test")).thenReturn(Arrays.asList(new AssetClientModel(), new AssetClientModel(), new AssetClientModel()));
        assertEquals(HttpStatus.OK, service.update().getHttpStatus());
    }

    @Test
    public void update_zeroAssets() {
        when(environment.getProperty("coin.api.api.key")).thenReturn("test");
        when(rest.getAll("test")).thenReturn(new ArrayList<>());
        assertEquals(HttpStatus.OK, service.update().getHttpStatus());
    }

    @Test
    public void update_nullAssets() {
        when(environment.getProperty("coin.api.api.key")).thenReturn("test");
        when(rest.getAll("test")).thenReturn(null);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, service.update().getHttpStatus());
    }

}
