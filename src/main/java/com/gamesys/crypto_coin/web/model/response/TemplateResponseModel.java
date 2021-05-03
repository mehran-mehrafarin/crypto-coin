package com.gamesys.crypto_coin.web.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gamesys.crypto_coin.web.model.response.ResponseModel;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemplateResponseModel implements ResponseModel {

    @JsonIgnore
    private  HttpStatus httpStatus;

    private String title;

    private String message;

    private Object model;

    private List models;

    private Integer totalPages;

    private Long totalElements;

    public TemplateResponseModel() {
    }

    public TemplateResponseModel(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public TemplateResponseModel(HttpStatus httpStatus, String title, String message) {
        this.httpStatus = httpStatus;
        this.title = title;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public List getModels() {
        return models;
    }

    public void setModels(List models) {
        this.models = models;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
