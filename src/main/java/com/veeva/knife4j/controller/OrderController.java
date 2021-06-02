package com.veeva.knife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = "订单模块")
//排序规则为倒序，最小值必须大于0，优先级：@ApiSupport>@ApiSort>@Api
@ApiSupport(order = 1)
@RestController
@RequestMapping("/order")
public class OrderController {

    @ApiOperationSupport(author = "sunshuo", order = 3)
    @ApiOperation(value = "获取真实文档3")
    @GetMapping("/getRealDoc3")
    public ResponseEntity<String> getRealDoc3() {
        ResponseEntity<String> realDoc = ResponseEntity.ok("Real Doc");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return realDoc;
    }

    @ApiOperationSupport(author = "sunshuo", order = 2)
    @ApiOperation(value = "获取真实文档4")
    @GetMapping("/getRealDoc4")
    public ResponseEntity<String> getRealDoc4() {
        ResponseEntity<String> realDoc = ResponseEntity.ok("Real Doc");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return realDoc;
    }
}
