package com.gamesys.crypto_coin.web.model.request;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;


public class TemplateRequestModel implements RequestModel {

    private Integer page;

    private Integer size;

    private String search;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
