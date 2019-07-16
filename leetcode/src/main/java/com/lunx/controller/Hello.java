package com.lunx.controller;

import com.lunx.glob.model.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(value = "/hello", tags = "hello", description = "Lunx")
@RestController
@RequestMapping("/hello")
public class Hello {

    @ApiOperation(value = "hello接口", notes = "测试使用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "first", value = "第一", dataType = "int", paramType = "query", required = false)
    })
    @GetMapping("/hello")
    public HttpResult<Boolean> getHello(@RequestParam(value = "first", required = false, defaultValue = "0") int first) {
        HttpResult<Boolean> result = new HttpResult<>();
        boolean data = false;
        System.out.println("*********** start ***********");

        System.out.println(first);

        System.out.println("*********** end ***********");
        return result.setData(data);
    }

    @ApiOperation(value = "hello接口", notes = "测试使用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "second", value = "第二", dataType = "int", paramType = "query", required = false)
    })
    @PostMapping("/hello")
    public HttpResult<Map<String, Object>> postHello(@RequestParam(value = "second", required = false, defaultValue = "0") int second) {
        HttpResult<Map<String, Object>> result = new HttpResult<>();
        Map<String, Object> data = new HashMap<>();
        System.out.println("*********** start ***********");

        System.out.println(second);

        System.out.println("*********** end ***********");
        return result.setData(data);
    }
}
