package com.cxk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/9 16:41
 * @Description：
 */
@SpringBootApplication
@EnableEurekaClient
public class NewsApp_8093 {

    public static void main(String[] args) {
        SpringApplication.run(NewsApp_8093.class,args);
    }

}
