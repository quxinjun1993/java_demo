package swagger2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;
import swagger2.utils.RedisUtils;

@Controller
@RequestMapping("/login")
@ApiIgnore
public class LoginController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/login")
    public String login(){
        System.out.println(redisUtils.get("ssss"));
        return "login";
    }

    @GetMapping("/notFoundHtml")
    public String notFoundHtml(){
        return "404";
    }

}
