package com.mercadinholegal.apiteste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBemVindo {

    @GetMapping("/welcome")
    public String bemvindo(){
        return "Bem vindo ao teste!";
    }
}
