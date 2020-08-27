package com.zms.springcloud.provider.controllers;


import com.springcloud.client.common.api.PostMessage;
import com.zms.springcloud.provider.dubbo.services.PostMessageProvider;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProviderController {
    private static final AtomicInteger count=new AtomicInteger();

    @Autowired
    private PostMessage postMessageProvider;

    @Reference
    private PostMessage provider;

    @RequestMapping("nihao")
    public String nihao(){
        postMessageProvider.sendMsg("nihao");
        provider.sendMsg("buhao");
        return "nihao";
    }

    @RequestMapping("hello")
    public String hello(){
        System.out.println("this is zms invoke:"+count.getAndIncrement());
        return "hello world";
    }



}
