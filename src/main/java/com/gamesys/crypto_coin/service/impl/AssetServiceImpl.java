package com.gamesys.crypto_coin.service.impl;


import com.gamesys.crypto_coin.repository.AssetRepository;
import com.gamesys.crypto_coin.service.AssetService;
import com.gamesys.crypto_coin.web.model.AssetModel;
import com.gamesys.crypto_coin.web.model.request.RequestModel;
import com.gamesys.crypto_coin.web.model.response.TemplateResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private AssetRepository repository;

    private Environment environment;

    private ModelMapper modelMapper;

    @Autowired
    public AssetServiceImpl(AssetRepository repository, Environment environment, ModelMapper modelMapper) {
        this.repository = repository;
        this.environment = environment;
        this.modelMapper = modelMapper;
    }

    @Override
    public TemplateResponseModel get() {

        List<AssetModel> models = repository.findAll().stream().map(e -> modelMapper.map(e, AssetModel.class)).collect(Collectors.toList());
        TemplateResponseModel response = new TemplateResponseModel();
        response.setHttpStatus(HttpStatus.OK);
        response.setModels(models);
        return response;
    }

    @Override
    public TemplateResponseModel getByAssetId(String assetId) {
        Optional optional = repository.findByAssetId(assetId);

        TemplateResponseModel response = new TemplateResponseModel();

        if (optional.isPresent()) {
            response.setHttpStatus(HttpStatus.OK);
            response.setModel(optional.get());
        } else {
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            response.setMessage(environment.getProperty("message.body.error.no.result"));
        }
        return response;
    }

    @Override
    public TemplateResponseModel getPaginated(RequestModel request) {

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        List<AssetModel> models = repository.findAll(pageable).stream().map(e -> modelMapper.map(e, AssetModel.class)).collect(Collectors.toList());
        TemplateResponseModel response = new TemplateResponseModel();
        response.setHttpStatus(HttpStatus.OK);
        response.setModels(models);
        return response;
    }
}
