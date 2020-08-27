package com.zms.springcloud.provider;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


// it's not use @SpringCloudApplication
// beacause the annotation need more dependencies example hystrix
@SpringBootApplication
//@EnableDiscoveryClient
@EnableDubbo
public class ProviderOneApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext=SpringApplication.run(ProviderOneApplication.class);
//        applicationContext.getBean("123");
    }
}
