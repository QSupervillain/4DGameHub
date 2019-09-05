package com.cxk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启eureka客户端
@EnableEurekaClient
public class Video_App {
    public static void main(String [] args){
        SpringApplication.run(Video_App.class, args);
    }
}
