package com.bonree.sdk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Bonree
 * @Date: 2020-4-7 18:05
 * @Desc:
 */
@RestController
public class SdkController {
    
    @RequestMapping("test")
    public String test(@RequestParam String name) {
        return "SDK for test string:" + name;
    }
    
    @RequestMapping("first")
    public String first() {
        return "SDK for test empty params";
    }
    
    @RequestMapping("second")
    public String second(@RequestParam Integer number) {
        return "SDK for test number:" + number;
    }
    
}
