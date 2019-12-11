package com.ylw.springboot.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FanoutProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String queueName) {
        String msg = "my_fanout_msg:" + new Date();
        System.out.println(msg + ":" + msg);
        amqpTemplate.convertAndSend(queueName, msg);
    }
}