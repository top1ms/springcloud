package com.zms.springcloud.gateway.zuul;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class NativeLoadBalancer extends AbstractLoadBalancerRule {

    public NativeLoadBalancer(){
        System.out.println("nativeLoadBalancer");
    }
    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    @Override
    public Server choose(Object key) {
        BaseLoadBalancer baseLoadBalancer= (BaseLoadBalancer) this.getLoadBalancer();
        RequestContext requestContext= RequestContext.getCurrentContext();
        String nativeIp= null;
        try {
            nativeIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances(baseLoadBalancer.getName());
        for(ServiceInstance instance:serviceInstances){
            if(instance.getHost().equals(nativeIp)){
                return new Server(instance.getHost(),instance.getPort());
            }
        }
        return null;
    }


    public String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
}
