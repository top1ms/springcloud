package com.zms.springcloud.client.common.api;

import com.springcloud.client.common.api.PostMessage;

public class PostMessageMain implements PostMessage {


    @Override
    public void sendMsg(String content) {
        System.out.println("adptive post:"+content);
    }
}
