package com.huarui.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义input output
 * Created by lihui on 2019/2/28.
 */
public interface StreamClient {


    public static final String INPUT = "myinput";

    public static final String OUTPUT = "myoutput";

    public static final String INPUTTO = "myinputto";

    public static final String OUTPUTTO = "myoutputto";

    /**
     * 相当于消费者consumer，它是从队列中接收消息的
     */
    @Input(INPUT)
    SubscribableChannel input();

    /**
     * 相当于生产者producer，它是从队列中发送消息的
     */
    @Output(OUTPUT)
    MessageChannel output();

    /**
     * 相当于消费者consumer，它是从队列中接收消息的 (反馈使用)
     */
    @Input(INPUTTO)
    SubscribableChannel inputto();

    /**
     * 相当于生产者producer，它是从队列中发送消息的 (反馈使用)
     */
    @Output(OUTPUTTO)
    MessageChannel outputto();

}
