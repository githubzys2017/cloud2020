package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 23:44 2020/5/29
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced         自己写负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
