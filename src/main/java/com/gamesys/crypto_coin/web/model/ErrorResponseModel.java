package com.gamesys.crypto_coin.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class ErrorResponseModel implements ResponseModel {

    @JsonIgnore
    private  HttpStatus httpStatus;
    private String title;
    private String message;
    private String description;


    public ErrorResponseModel(HttpStatus httpStatus, String title, String message) {
        this.httpStatus = httpStatus;
        this.title = title;
        this.message = message;
    }

    public ErrorResponseModel(HttpStatus httpStatus, String title, String message, String description) {
        this.httpStatus = httpStatus;
        this.title = title;
        this.message = message;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
