package com.huarui.message;

import com.huarui.entity.Girl;
import com.huarui.util.JsonUtils;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by lihui on 2019/2/28.
 */

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    /**
     * 基本 INPUT
     * @param girlStr
     */
    @StreamListener(StreamClient.INPUT)
    public void process(String girlStr){
        Girl girl = JsonUtils.parseObject(girlStr, Girl.class);
        System.out.println("process 收到: "+girl);
    }

    /**
     * 我们接收到消息后，给别人一个反馈
     * SpringCloud stream 给我们提供了一个SendTo注解可以帮我们干这些事情
     * @param girlStr
     * @return
     */
    @StreamListener(StreamClient.INPUTTO)
    @SendTo(StreamClient.OUTPUTTO)
    public String processTo(String girlStr){
        Girl girl = JsonUtils.parseObject(girlStr, Girl.class);
        System.out.println("收到: "+girl);
        return JsonUtils.parseString(girl);
    }

    @StreamListener(StreamClient.OUTPUTTO)
    public void process2(String girlStr){
        Girl girl = JsonUtils.parseObject(girlStr, Girl.class);
        System.out.println("ta 已收到: "+girl);
    }

}
