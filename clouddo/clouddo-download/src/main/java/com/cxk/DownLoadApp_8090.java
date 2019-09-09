package com.cxk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:46
 * @Description：
 */
@SpringBootApplication
//开启eureka客户端
@EnableEurekaClient
//异步调用
@EnableAsync
public class DownLoadApp_8090 {

    public ../../static void main(String[] args) {
        SpringApplication.run(DownLoadApp_8090.class, args);
    }

}
