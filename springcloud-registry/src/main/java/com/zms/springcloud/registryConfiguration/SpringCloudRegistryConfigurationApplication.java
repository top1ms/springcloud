package com.zms.springcloud.registryConfiguration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaServer
public class SpringCloudRegistryConfigurationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringCloudRegistryConfigurationApplication.class);
        applicationContext.getEnvironment().getProperty("ss");
    }


}
