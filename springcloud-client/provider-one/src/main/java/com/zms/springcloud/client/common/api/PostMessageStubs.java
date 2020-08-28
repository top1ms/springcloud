package com.zms.springcloud.client.common.api;

import com.springcloud.client.common.api.PostMessage;

public class PostMessageStubs implements PostMessage {
    private PostMessage postMessage;

    public PostMessageStubs(PostMessage postMessage){
        this.postMessage=postMessage;
    }

    @Override
    public void sendMsg(String content) {
        System.out.println("before executes:"+System.currentTimeMillis());
        postMessage.sendMsg(content);
        System.out.println("after executes:"+System.currentTimeMillis());
    }

}
