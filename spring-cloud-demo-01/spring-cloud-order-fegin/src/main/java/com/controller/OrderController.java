package com.controller;

import com.interfacies.FeginClientService;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private FeginClientService feginClientService;

    @GetMapping("/order/{id}")
    public User getUserForOrder(@PathVariable("id")int id){
        return feginClientService.getOrderUser(id);
    }

}
