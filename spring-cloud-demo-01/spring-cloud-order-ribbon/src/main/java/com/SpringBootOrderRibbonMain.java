package com;

import config.TestRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRING-CLOUD-USER",configuration = TestRibbonConfig.class)//启用 ribbon 并对SPRING-CLOUD-USER进行负载均衡
public class SpringBootOrderRibbonMain {

    @Bean
    public RestTemplate getTemp(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOrderRibbonMain.class);
    }

}
