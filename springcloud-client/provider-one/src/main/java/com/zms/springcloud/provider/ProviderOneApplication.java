package com.zms.springcloud.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


// it's not use @SpringCloudApplication
// beacause the annotation need more dependencies example hystrix
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOneApplication.class);
    }
}
