package com.cxk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author ：大大怪将军S
 * @Date ：2019/9/3 23:02
 * @Description：
 */
@SpringBootApplication
//开启注册中心server
@EnableEurekaServer
public class EurekaServerApp_8010 {

    public ../../static void main(String[] args) {
        SpringApplication.run(EurekaServerApp_8010.class, args);
    }

}