package com.interfacies;

import com.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SPRING-CLOUD-USER")
public interface FeginClientService {

    //    @GetMapping("/user/{id}")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User getOrderUser(@PathVariable("id")int id);

}
