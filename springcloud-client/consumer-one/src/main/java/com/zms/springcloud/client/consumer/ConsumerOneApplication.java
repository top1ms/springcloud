package com.zms.springcloud.client.consumer;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class ConsumerOneApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumerOneApplication.class);


//        Method method= ClassUtils.getPublicMethod(ConsumerOneApplication.class,"sayHello",null);
//        Method invoke= org.springframework.util.ClassUtils.getMostSpecificMethod(method,Lv.class);
//        invoke.invoke(new ConsumerOneApplication.Lv(),null);
    }

}
