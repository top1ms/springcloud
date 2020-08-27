package com.zms.springcloud.provider.dubbo.services;


import com.springcloud.client.common.api.PostMessage;
import org.apache.dubbo.config.annotation.Service;

@Service(stub = "com.zms.springcloud.client.common.api.PostMessageStub")
public class PostMessageProvider implements PostMessage {


    @Override
    public void sendMsg(String content) {
        System.out.println("dubbo provider send messgae:"+content);
    }
}
