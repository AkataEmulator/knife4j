package com.veeva.knife4j.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品模块")
//排序规则为倒序，最小值必须大于0，优先级：@ApiSupport>@ApiSort>@Api
@ApiSort(2)
@RestController
@RequestMapping("/product")
public class ProductController {
    @ApiImplicitParam(name = "name", value = "productName", required = true)
    @ApiOperation(value = "查询商品")
    @GetMapping("/product")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Product:" + name);
    }
}
