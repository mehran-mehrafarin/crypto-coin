package com.gamesys.crypto_coin.web.rest;

import com.gamesys.crypto_coin.client.service.impl.AssetClientServiceImpl;
import com.gamesys.crypto_coin.service.AssetService;
import com.gamesys.crypto_coin.web.model.AssetModel;
import com.gamesys.crypto_coin.web.model.request.TemplateRequestModel;
import com.gamesys.crypto_coin.web.model.response.TemplateResponseModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AssetRest.class)
public class AssetRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssetService service;

    @MockBean
    private AssetClientServiceImpl clientService;

    @MockBean
    private Environment environment;


    @Test
    public void update_basic() throws Exception {

        when(clientService.update()).thenReturn(new TemplateResponseModel(HttpStatus.OK, "Success", "Every thing is fine"));

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/assets/update").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        assertEquals("{\"title\":\"Success\",\"message\":\"Every thing is fine\"}", result.getResponse().getContentAsString());

    }


}
