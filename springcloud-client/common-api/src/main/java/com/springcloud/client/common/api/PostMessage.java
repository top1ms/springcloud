package com.springcloud.client.common.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("main")
public interface PostMessage {

    void sendMsg(String content);

    @Adaptive
    default void sendMsg(URL url,String content){}
//    void sendMsg(String content);
}
