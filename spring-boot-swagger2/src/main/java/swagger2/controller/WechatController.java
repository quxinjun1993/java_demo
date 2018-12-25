package swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import swagger2.constant.ResponseServer;

@RestController
@RequestMapping("/wx")
@Api(description = "微信接口")
public class WechatController {


    @PostMapping("/getWxInfo")
    @ApiOperation(value = "微信测试接口", notes = "微信测试接口",httpMethod = "POST")
    public void getWxInfo(){

    }

    @DeleteMapping("/deleteMethod/{id}")
    @ApiOperation(value = "DELETE方法", notes = "DELETE方法",httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String")
    public ResponseServer deleteMethod(@PathVariable String id){
        return ResponseServer.createBySuccess("删除成功！");
    }


    @PutMapping("/putMethod/{id}")
    @ApiOperation(value = "PUT方法", notes = "PUT方法",httpMethod = "PUT")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String")
    public ResponseServer putMethod(@PathVariable String id){
        return ResponseServer.createBySuccess("删除成功！");
    }

    @GetMapping("/getMethod/{id}")
    @ApiOperation(value = "GET方法", notes = "GET方法",httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String")
    public ResponseServer getMethod(@PathVariable String id){
        return ResponseServer.createBySuccess("删除成功！");
    }

    @PostMapping("/getMethod/{id}")
    @ApiOperation(value = "POST方法", notes = "POST方法",httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String")
    public ResponseServer POSTMethod(@PathVariable String id){
        return ResponseServer.createBySuccess("删除成功！");
    }

}
