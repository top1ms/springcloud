package com.zms.springcloud.provider.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }
}
