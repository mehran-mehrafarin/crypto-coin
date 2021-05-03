package com.gamesys.crypto_coin.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class TemplateResponseModel implements ResponseModel {


    @JsonIgnore
    private  HttpStatus httpStatus;
    private String title;
    private String message;


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
}
