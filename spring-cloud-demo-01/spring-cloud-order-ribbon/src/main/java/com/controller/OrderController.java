package com.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Value("${user.url}")
//    private String url;

    private String getHomeUrl() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SPRING-CLOUD-USER", false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/order/{id}")
    public User getUserForOrder(@PathVariable int id) {
//        User user = restTemplate.getForObject(this.getHomeUrl() + "/user/" + id,User.class);
        User user = restTemplate.getForObject("http://SPRING-CLOUD-USER/user/" + id, User.class);
        return user;
    }

    @GetMapping("/test")
    public String test() {
        //查找实例对象
        ServiceInstance serviceInstance_1 = loadBalancerClient.choose("SPRING-CLOUD-USER");
        String url_info =  serviceInstance_1.getServiceId() + "::" + serviceInstance_1.getHost() + ":" + serviceInstance_1.getPort();
        System.err.println("url_info:" + url_info);

        ServiceInstance serviceInstance_2 = loadBalancerClient.choose("SPRING-CLOUD-USER-1");
        String url_info2 =  serviceInstance_2.getServiceId() + "::" + serviceInstance_2.getHost() + ":" + serviceInstance_2.getPort();
        System.err.println("url_info2:" + url_info2);
        return url_info;
    }

}
