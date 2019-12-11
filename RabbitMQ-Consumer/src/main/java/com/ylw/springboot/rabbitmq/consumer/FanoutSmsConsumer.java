package com.ylw.springboot.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class FanoutSmsConsumer {

    @RabbitListener(queues = "fanout_sms_queue")
    public void process(Message message) throws Exception {
        String messageId = message.getMessageProperties().getMessageId();
        System.out
                .println(Thread.currentThread().getName() + ",邮件消费者获取生产者消息msg:" + new String(message.getBody(), "UTF-8")
                        + ",messageId:" + messageId);
        /*if(hasFinished(messageId)){
            //如果消息处理完了，则直接完成，不消费信息
            return;
        }*/
    }

    /*
    @RabbitHandler
    public void process(String msg) {
        System.out.println("短信消费者获取生产者消息msg:" + msg);
       *//* Result result = OkHttpCientUtils(url,json);

        if(result == null){
            throw new Exception("调用第三方接口失败");
        }
        System.out.println("调用第三方接口与成功");*//*
    }
    */


}