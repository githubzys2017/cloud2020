package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixservice;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 9:09 2020/6/13
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_Fallbackmethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixservice paymentHystrixservice;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixservice.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/out/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i = 2/0;
        String result = paymentHystrixservice.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutFallbackMethod(Integer id) {
        return "我是消费者80，对方支付系统繁忙";
    }

    /**
     * 全局fallback
     * @return
     */
    public String payment_Global_Fallbackmethod() {
        return "全局fallback";
    }
}
