package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 21:00 2020/6/12
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "\t" + "O(∩_∩)O";
    }

    public String paymentInfo_TimeOut(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id + "\t" + "哈哈" + "耗时（秒）：" + time;
    }
}
