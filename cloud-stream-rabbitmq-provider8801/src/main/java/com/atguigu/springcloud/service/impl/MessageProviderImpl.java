package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: 张永帅
 * @Description:
 * @Date: Create in 20:55 2020/7/27
 */
@EnableBinding(Source.class)        //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;      //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder.withPayload(serial).build();
        output.send(message);
        System.out.println("******serial*********** : " + serial);
        return null;
    }
}
