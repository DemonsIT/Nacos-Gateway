package com.bonree.sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SdkApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SdkApplication.class, args);
    }
    
}
