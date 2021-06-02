package com.veeva.knife4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户模块", position = 2)
//排序规则为倒序，最小值必须大于0，优先级：@ApiSupport>@ApiSort>@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiImplicitParam(name = "name", value = "userName", required = true)
    @ApiOperation(value = "query userInfo")
    @GetMapping("/user")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("User:" + name);
    }
}
