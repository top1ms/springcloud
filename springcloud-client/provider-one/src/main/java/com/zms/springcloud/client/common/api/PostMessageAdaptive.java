package com.zms.springcloud.client.common.api;

import com.springcloud.client.common.api.PostMessage;
import org.apache.dubbo.common.extension.Adaptive;

//@Adaptive
public class PostMessageAdaptive implements PostMessage {
    @Override
    public void sendMsg(String content) {
        System.out.println("adptive post message:"+content);
    }
}
