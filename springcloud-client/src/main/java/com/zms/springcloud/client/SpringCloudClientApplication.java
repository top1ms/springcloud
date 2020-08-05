package com.zms.springcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudClientApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringCloudClientApplication.class);
                Zms zms= (Zms) applicationContext.getBean("zms");
        System.out.println(zms.getName());
    }


}
