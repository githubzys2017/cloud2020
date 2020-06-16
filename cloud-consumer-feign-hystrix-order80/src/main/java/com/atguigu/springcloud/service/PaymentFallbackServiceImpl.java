package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 22:34 2020/6/14
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixservice {
    @Override
    public String paymentInfo_OK(Integer id) {

        return "----- paymentFallbakservice fall back - paymentInfo_ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----- paymentFallbakservice fall back - paymentInfo_out";
    }
}
