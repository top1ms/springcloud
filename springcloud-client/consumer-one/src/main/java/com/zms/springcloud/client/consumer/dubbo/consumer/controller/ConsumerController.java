package com.zms.springcloud.client.consumer.dubbo.consumer.controller;


import com.springcloud.client.common.api.PostMessage;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Reference(stub = "com.zms.springcloud.client.common.api.PostMessageStub")
    private PostMessage postMessage;


    @RequestMapping("hello")
    public String hello(){
        postMessage.sendMsg("heihei");
        return "nihao";
    }
}
