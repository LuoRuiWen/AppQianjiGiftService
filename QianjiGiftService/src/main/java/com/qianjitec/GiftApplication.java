package com.qianjitec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GiftApplication {
    public static void main(String []args){
        SpringApplication.run(GiftApplication.class,args);
    }
}
