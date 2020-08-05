package com.zms.springcloud.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurationApplication=(ConfigurableApplicationContext) SpringApplication.run(ConfigurationApplication.class);
//        Zms zms= (Zms) configurationApplication.getBean("zms");
//        System.out.println(zms.getName());



    }

    public class Zms{
        @Value("${spring.cloud.config.server.prefix:12}")
        private String name;

        public String getName() {
            return name;
        }
    }

}
