package com.huarui.controller;

import com.huarui.entity.Girl;
import com.huarui.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lihui on 2019/2/28.
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendGirl/{name}")
    public String sendGirl(@PathVariable String name){
        Girl girl = new Girl(UUID.randomUUID().toString(),name,new Date());
        streamClient.output().send(MessageBuilder.withPayload(girl).build());
        return name+" send ok";
    }

    @GetMapping("/sendGirlTo/{name}")
    public String sendGirlTo(@PathVariable String name){
        Girl girl = new Girl(UUID.randomUUID().toString(),name,new Date());
        streamClient.outputto().send(MessageBuilder.withPayload(girl).build());
        return name+" send ok";
    }

}
