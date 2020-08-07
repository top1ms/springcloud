package com.zms.springcloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringCloudApplication
@EnableZuulServer
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
