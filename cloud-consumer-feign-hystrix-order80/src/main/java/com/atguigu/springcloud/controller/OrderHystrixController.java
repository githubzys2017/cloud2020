package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixservice;
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
public class OrderHystrixController {

    @Resource
    private PaymentHystrixservice paymentHystrixservice;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixservice.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/out/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixservice.paymentInfo_TimeOut(id);
        return result;
    }
}
