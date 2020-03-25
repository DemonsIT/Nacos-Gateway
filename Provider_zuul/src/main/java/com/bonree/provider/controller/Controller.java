package com.bonree.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @RequestMapping("/api")
    public String getApiInfo() {
        return "I'm provider_zuul api, i received your msg!";
    }
    
    @RequestMapping("/info")
    public String getInfo() {
        return "I'm provider_zuul info, i received your msg!";
    }
    
}
