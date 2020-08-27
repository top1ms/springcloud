package com.zms.springcloud.client.common.api;

import com.springcloud.client.common.api.PostMessage;

public class PostMessageStub implements PostMessage {

    private PostMessage postMessage;

    public PostMessageStub(PostMessage postMessage){
        this.postMessage=postMessage;
    }


    @Override
    public void sendMsg(String content) {
        System.out.println("before rpc:"+System.currentTimeMillis());
        postMessage.sendMsg(content);
        System.out.println("after rpc:"+System.currentTimeMillis());
    }
}
