package com.cxk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/15 20:53
 * @Description：
 */
@EnableEurekaClient
@SpringBootApplication
public class AdminApp_8094 {
    public static void main(String[] args) {
        SpringApplication.run(AdminApp_8094.class,args);
    }
}