package com.gamesys.crypto_coin.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/hello-world")
public class HelloWorldRest {

    @GetMapping
    public ResponseEntity greeting() {
        return ResponseEntity.ok("Hello World!");
    }
}
