package com.jiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiang.entity.CommonResult;
import com.jiang.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("登录")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string",paramType = "query"),
    })
    @PostMapping("/loginUser")
    public CommonResult loginUser(@RequestBody JSONObject loginJson){
        String username = loginJson.get("username").toString();
        String password = loginJson.get("password").toString();

        return loginService.loginUser(username,password);
    }

}
