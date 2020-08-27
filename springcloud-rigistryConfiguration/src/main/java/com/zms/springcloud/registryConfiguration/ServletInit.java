package com.zms.springcloud.registryConfiguration;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class ServletInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("hehe");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
