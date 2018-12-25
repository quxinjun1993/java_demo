package swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import swagger2.constant.ResponseServer;
import swagger2.model.User;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@Api(value = "UserController", description = "用户接口")
@PropertySource("classpath:config.properties")
public class UserController {

    @Value("${integer.port}")
    private int intPort;
    @Value("${string.port}")
    private String stringPort;
    @Value("${db.link.url}")
    private String dbUrl;
    @Value("${db.link.driver}")
    private String dbDriver;
    @Value("${db.link.username}")
    private String dbUsername;
    @Value("${db.link.password}")
    private String dbPassword;
    @Value("${message}")
    private String message;

    @GetMapping("/getUserInfo/{id}")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header", dataType = "String")
    })
    public User getUserInfo(@PathVariable String id, HttpServletRequest request) {
        String token = request.getHeader("token");
        int this_id = Integer.valueOf(id);
        return new User(this_id, "屈新竣", token);
    }

    @PostMapping("/getUserInfo2/{id}")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", response = User.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header", dataType = "String")
    })
    public ResponseServer getUserInfo2(@PathVariable String id, HttpServletRequest request) {
        String token = request.getHeader("token");
        int this_id = Integer.valueOf(id);
        return ResponseServer.createBySuccess(new User(this_id, "屈新竣", token));
    }

    @PostMapping("/getUser")
    @ApiOperation(value = "创建用户", notes = "创建用户", response = User.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "address", value = "住宅地址", required = true, paramType = "query", dataType = "String")
    })
    public ResponseServer getUser(@RequestParam String name, @RequestParam String address) {
        return ResponseServer.createBySuccess(new User(1000, name, address));
    }

    @PostMapping("/modifyUserInfo")
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", response = User.class)
    public ResponseServer modifyUserInfo(@RequestBody User user) {
        return ResponseServer.createBySuccess(user);
    }


}
