package com.zms.springcloud.gateway.zuul;

import com.netflix.loadbalancer.Server;

public class NativeServer extends Server {

    public NativeServer(String host, int port) {
        super(host, port);
    }
}
