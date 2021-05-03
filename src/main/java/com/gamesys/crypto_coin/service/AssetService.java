package com.gamesys.crypto_coin.service;

import com.gamesys.crypto_coin.web.model.request.RequestModel;
import com.gamesys.crypto_coin.web.model.response.TemplateResponseModel;

public interface AssetService {

    TemplateResponseModel get();

    TemplateResponseModel getByAssetId(String assetId);

    TemplateResponseModel getPaginated(RequestModel request);

}
