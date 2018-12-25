package swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Api(description = "订单接口")
public class OrderController {

    @GetMapping("/getInfo")
    @ApiOperation(value = "测试接口", notes = "测试接口")
    public String getInfo(){
        return "Hello World!";
    }





}
