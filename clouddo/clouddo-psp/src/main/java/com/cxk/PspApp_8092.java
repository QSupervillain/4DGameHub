package com.cxk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/5 19:08
 * @Description：
 */
@EnableEurekaClient
@SpringBootApplication
public class PspApp_8092 {
    public static void main(String[] args) {
        SpringApplication.run(PspApp_8092.class,args);
    }
}