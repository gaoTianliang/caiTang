package com.code.net.controller;

import com.code.net.common.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gtl
 * @version 1.0
 * @date 2020/4/8 15:12
 */
@RestController
@RequestMapping("/redis")
@Api(tags = "redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "查询数据")
    @GetMapping("/select")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "键"),
    })
    public String select(@RequestParam String key) {
        Object o = redisService.get(key);
        return o.toString();
    }

    @ApiOperation(value = "插入数据")
    @PostMapping("/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "键"),
            @ApiImplicitParam(name = "value", value = "值"),
    })
    public void add(@RequestParam String key, @RequestParam String value) {
        redisService.set(key,value);
    }
}
