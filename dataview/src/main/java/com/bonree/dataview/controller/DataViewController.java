package com.bonree.dataview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Bonree
 * @Date: 2020-4-7 18:05
 * @Desc:
 */
@RestController
public class DataViewController {
    
    @RequestMapping("test")
    public String test(@RequestParam String name) {
        return "DataView for test string:" + name;
    }
    
    @RequestMapping("first")
    public String first() {
        return "DataView for test empty params";
    }
    
    @RequestMapping("second")
    public String second(@RequestParam Integer number) {
        return "DataView for test number:" + number;
    }
    
}
