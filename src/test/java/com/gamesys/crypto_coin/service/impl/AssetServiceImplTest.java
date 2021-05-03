package com.gamesys.crypto_coin.service.impl;

import com.gamesys.crypto_coin.entity.Asset;
import com.gamesys.crypto_coin.repository.AssetRepository;
import com.gamesys.crypto_coin.web.model.request.TemplateRequestModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssetServiceImplTest {


    @InjectMocks
    private AssetServiceImpl service;

    @Mock
    private AssetRepository repository;

    @Mock
    private Environment environment;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void get_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Asset(), new Asset(), new Asset()));
        assertEquals(3, this.service.get().getModels().size());
    }

    @Test
    public void getByAssetId_basic() {
        Asset entity = new Asset();
        entity.setAssetId("BTC");
        when(repository.findByAssetId("BTC")).thenReturn(Optional.of(entity));
        assertEquals("BTC", ((Asset) this.service.getByAssetId("BTC").getModel()).getAssetId());
    }

    @Test
    public void getPaginated_basic() {
        Pageable pageable = PageRequest.of(0, 3);
        TemplateRequestModel request = new TemplateRequestModel();
        request.setPage(0);
        request.setSize(3);

        when(repository.findAll(pageable)).thenReturn(Arrays.asList(new Asset(), new Asset(), new Asset()));
        assertEquals(3, this.service.getPaginated(request).getModels().size());
    }


}
