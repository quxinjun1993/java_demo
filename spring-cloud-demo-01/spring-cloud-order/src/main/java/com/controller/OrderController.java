package com.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Value("${user.url}")
//    private String url;

    private String getHomeUrl(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SPRING-CLOUD-USER",false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/order/{id}")
    public User getUserForOrder(@PathVariable int id){
        User user = restTemplate.getForObject(this.getHomeUrl() + "/user/" + id,User.class);
        return user;
    }

}
