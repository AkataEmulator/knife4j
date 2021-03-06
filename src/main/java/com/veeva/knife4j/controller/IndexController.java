package com.veeva.knife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = "首页模块")
@RestController
@RequestMapping("/home")
public class IndexController {

    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

    @ApiOperationSupport(author = "sunshuo", order = 2)
    @ApiOperation(value = "获取真实文档")
    @GetMapping("/getRealDoc")
    public ResponseEntity<String> getRealDoc() {
        ResponseEntity<String> realDoc = ResponseEntity.ok("Real Doc");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return realDoc;
    }

    @ApiOperationSupport(author = "sunshuo", order = 1)
    @ApiOperation(value = "获取真实文档2")
    @GetMapping("/getRealDoc2")
    public ResponseEntity<String> getRealDoc2() {
        ResponseEntity<String> realDoc = ResponseEntity.ok("Real Doc");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return realDoc;
    }
}
