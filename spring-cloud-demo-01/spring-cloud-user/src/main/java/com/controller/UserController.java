package com.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User user = new User(id);
        return user;
    }

    @GetMapping("/testInfo")
    public String info(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SPRING-CLOUD-USER",false);
        return instanceInfo.getHomePageUrl();
    }

}
