package com.zms.springcloud.provider.dubbo.services;


import com.springcloud.client.common.api.PostUserInfo;
import org.apache.dubbo.config.annotation.Service;

@Service
public class PostUserInfoProvider implements PostUserInfo {

    @Override
    public void postUserInfo() {
        System.out.println("happy birthDay ");
    }
}
