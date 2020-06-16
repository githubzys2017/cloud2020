package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 23:26 2020/6/12
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixmain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixmain80.class, args);
    }
}
